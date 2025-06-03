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
			        p.last_name AS lastName
			    FROM booking b
			    JOIN passenger p ON b.passenger_id = p.passenger_id
			    WHERE b.user_id = :userId
			      AND b.status <> 9
			    ORDER BY b.booking_time DESC
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