package com.example.flightapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.flightapi.entity.Flight;
import com.example.flightapi.projection.FlightWithAirportInfoProjection;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
	@Query(value = """
				SELECT
					f.flight_id AS flightId,
					f.flight_number AS flightNumber,

					f.departure_airport_id AS departureAirportId,
					dep.code AS depCode,
					dep.name AS depName,
					dep.city AS depCity,

					f.arrival_airport_id AS arrivalAirportId,
					arr.code AS arrCode,
					arr.name AS arrName,
					arr.city AS arrCity,

					f.stop_airport_id AS stopAirportId,
					stop.code AS stopCode,
					stop.name AS stopName,
					stop.city AS stopCity,

					f.departure_time AS departureTime,
					f.arrival_time AS arrivalTime,
					f.stop_time AS stopTime,

					f.overnight_flag AS overnightFlag,
					f.plane_type AS planeType,
					f.company_name AS companyName,

					f.price_class_f AS priceClassF,
					f.price_class_c AS priceClassC,
					f.price_class_y AS priceClassY

				FROM flight f
				JOIN airport dep ON f.departure_airport_id = dep.airport_id
				JOIN airport arr ON f.arrival_airport_id = arr.airport_id
				LEFT JOIN airport stop ON f.stop_airport_id = stop.airport_id

				WHERE dep.city = :depCity
				  AND arr.city = :arrCity
				  AND f.stop_airport_id IS NOT NULL
			""", nativeQuery = true)
	List<FlightWithAirportInfoProjection> getFlightHasStop(@Param("depCity") String depCity, @Param("arrCity") String arrCity);

	@Query(value = """
			SELECT
				f.flight_id AS flightId,
				f.flight_number AS flightNumber,

				f.departure_airport_id AS departureAirportId,
				dep.code AS depCode,
				dep.name AS depName,
				dep.city AS depCity,

				f.arrival_airport_id AS arrivalAirportId,
				arr.code AS arrCode,
				arr.name AS arrName,
				arr.city AS arrCity,

				f.departure_time AS departureTime,
				f.arrival_time AS arrivalTime,
				f.stop_time AS stopTime,

				f.overnight_flag AS overnightFlag,
				f.plane_type AS planeType,
				f.company_name AS companyName,

				f.price_class_f AS priceClassF,
				f.price_class_c AS priceClassC,
				f.price_class_y AS priceClassY

			FROM flight f
			JOIN airport dep ON f.departure_airport_id = dep.airport_id
			JOIN airport arr ON f.arrival_airport_id = arr.airport_id

			WHERE dep.city = :depCity
			  AND arr.city = :arrCity
			  AND f.stop_airport_id IS NULL
		""", nativeQuery = true)
	List<FlightWithAirportInfoProjection> getFlightNoStop(@Param("depCity") String depCity, @Param("arrCity") String arrCity);

	@Query(value = """
			SELECT
				f.flight_id AS flightId,
				f.flight_number AS flightNumber,

				f.departure_airport_id AS departureAirportId,
				dep.code AS depCode,
				dep.name AS depName,
				dep.city AS depCity,

				f.arrival_airport_id AS arrivalAirportId,
				arr.code AS arrCode,
				arr.name AS arrName,
				arr.city AS arrCity,

				f.stop_airport_id AS stopAirportId,
				stop.code AS stopCode,
				stop.name AS stopName,
				stop.city AS stopCity,

				f.departure_time AS departureTime,
				f.arrival_time AS arrivalTime,
				f.stop_time AS stopTime,

				f.overnight_flag AS overnightFlag,
				f.plane_type AS planeType,
				f.company_name AS companyName,

				f.price_class_f AS priceClassF,
				f.price_class_c AS priceClassC,
				f.price_class_y AS priceClassY

			FROM flight f
			JOIN airport dep ON f.departure_airport_id = dep.airport_id
			JOIN airport arr ON f.arrival_airport_id = arr.airport_id
			LEFT JOIN airport stop ON f.stop_airport_id = stop.airport_id

			WHERE dep.city = :depCity
			  AND arr.city = :arrCity
		""", nativeQuery = true)
	List<FlightWithAirportInfoProjection> getFlightByCity(@Param("depCity") String depCity, @Param("arrCity") String arrCity);
}
