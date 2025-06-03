DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    user_id NUMERIC(8,0) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender NUMERIC(1,0) NOT NULL,
    country VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);
DROP TABLE IF EXISTS AIRPORT;
CREATE TABLE AIRPORT (
    airport_id NUMERIC(8,0) AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL
);
DROP TABLE IF EXISTS PASSENGER;
CREATE TABLE PASSENGER (
    passenger_id NUMERIC(8,0) AUTO_INCREMENT PRIMARY KEY,
    user_id NUMERIC(8,0) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100)
);
DROP TABLE IF EXISTS FLIGHT;
CREATE TABLE FLIGHT (
    flight_id NUMERIC(8,0) AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(10) NOT NULL,
    departure_airport_id NUMERIC(8,0) NOT NULL,
    arrival_airport_id NUMERIC(8,0) NOT NULL,
    stop_airport_id NUMERIC(8,0),
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    stop_time TIME,
    overnight_flag NUMERIC(1,0) NOT NULL,
    plane_type VARCHAR(20) NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    price_class_f NUMERIC(8,2),
    price_class_c NUMERIC(8,2),
    price_class_y NUMERIC(8,2) NOT NULL
);
DROP TABLE IF EXISTS BOOKING;
CREATE TABLE BOOKING (
    booking_id NUMERIC(8,0) AUTO_INCREMENT PRIMARY KEY,
    booking_no VARCHAR(100) NOT NULL,
    user_id NUMERIC(8,0) NOT NULL,
    passenger_id NUMERIC(8,0) NOT NULL,
    flight_id_outbound NUMERIC(8,0) NOT NULL,
    flight_id_return NUMERIC(8,0),
    outbound_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP,
    status NUMERIC(1,0) NOT NULL,
    class VARCHAR(1) NOT NULL,
    booking_time TIMESTAMP NOT NULL,
    price NUMERIC(8,2) NOT NULL
);