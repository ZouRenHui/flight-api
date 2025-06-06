package com.example.flightapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.flightapi.entity.Booking;
import com.example.flightapi.projection.BookingWithPassengerProjection;

import jakarta.transaction.Transactional;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	@Query(value = """
			SELECT
			    b.booking_id AS bookingId,
			    b.booking_no AS bookingNo,
			    b.user_id AS userId,
			    b.passenger_id AS passengerId,
			    b.flight_id_outbound AS flightIdOutbound,
			    b.flight_id_return AS flightIdReturn,
			    TO_CHAR(b.outbound_date, 'YYYY-MM-DD HH24:MI:SS') AS outboundDate,
			    TO_CHAR(b.return_date, 'YYYY-MM-DD HH24:MI:SS') AS returnDate,
			    b.status AS status,
			    b.class AS flightClass,
			    TO_CHAR(b.booking_time, 'YYYY-MM-DD HH24:MI:SS') AS bookingTime,
			    b.price AS price,
			    p.first_name AS firstName,
			    p.last_name AS lastName,
			    dep_airport_out.city AS outboundDepCity,
			    dep_airport_out.name AS outboundDepAirportName,
			    dep_airport_out.code AS outboundDepAirportCode,
			    f_out.departure_time AS outboundDepTime,
			    arr_airport_out.city AS outboundArrCity,
			    arr_airport_out.name AS outboundArrAirportName,
			    arr_airport_out.code AS outboundArrAirportCode,
			    f_out.arrival_time AS outboundArrTime,
			    dep_airport_return.city AS returnDepCity,
			    dep_airport_return.name AS returnDepAirportName,
			    dep_airport_return.code AS returnDepAirportCode,
			    f_return.departure_time AS returnDepTime,
			    arr_airport_return.city AS returnArrCity,
			    arr_airport_return.name AS returnArrAirportName,
			    arr_airport_return.code AS returnArrAirportCode,
			    f_return.arrival_time AS returnArrTime
			FROM booking b
			JOIN passenger p ON b.passenger_id = p.passenger_id
			JOIN flight f_out ON b.flight_id_outbound = f_out.flight_id
			JOIN airport dep_airport_out ON f_out.departure_airport_id = dep_airport_out.airport_id
			JOIN airport arr_airport_out ON f_out.arrival_airport_id = arr_airport_out.airport_id
			LEFT JOIN flight f_return ON b.flight_id_return = f_return.flight_id
			LEFT JOIN airport dep_airport_return ON f_return.departure_airport_id = dep_airport_return.airport_id
			LEFT JOIN airport arr_airport_return ON f_return.arrival_airport_id = arr_airport_return.airport_id
			WHERE b.user_id = :userId
			  AND b.status <> 9
			ORDER BY b.booking_time DESC;
									""", nativeQuery = true)
	List<BookingWithPassengerProjection> findByUserId(@Param("userId") Integer userId);

	@Modifying
	@Transactional
	@Query(value = """
			UPDATE booking b SET
				b.status = :status
			WHERE b.booking_no = :bookingNo
			""", nativeQuery = true)
	void updateStatus(@Param("status") Integer status, @Param("bookingNo") String bookingNo);

	@Modifying
	@Transactional
	@Query(value = """
			DELETE FROM booking b
			WHERE b.booking_no = :bookingNo
			""", nativeQuery = true)
	void deleteByBookingNo(@Param("bookingNo") String bookingNo);

	@Query(value = """
			    SELECT
			    	b.booking_id AS bookingId,
			        b.booking_no AS bookingNo,
			        b.user_id AS userId,
			        b.passenger_id AS passengerId,
			        b.flight_id_outbound AS flightIdOutbound,
			        b.flight_id_return AS flightIdReturn,
			        TO_CHAR(b.outbound_date, 'YYYY-MM-DD HH24:MI:SS') AS outboundDate,
			        TO_CHAR(b.return_date, 'YYYY-MM-DD HH24:MI:SS') AS returnDate,
			        b.status AS status,
			        b.class AS flightClass,
			        TO_CHAR(b.booking_time, 'YYYY-MM-DD HH24:MI:SS') AS bookingTime,
			        b.price AS price,
			        p.first_name AS firstName,
			        p.last_name AS lastName
			    FROM booking b
			    JOIN passenger p ON b.passenger_id = p.passenger_id
			    WHERE b.user_id = :userId
			      AND b.status <> 9
			      AND b.booking_time = (
			          SELECT MAX(booking_time) FROM booking WHERE user_id = :userId AND status <> 9
			      )
			""", nativeQuery = true)
	List<BookingWithPassengerProjection> findAllByUserIdAndLatestBookingTime(@Param("userId") Integer userId);
}