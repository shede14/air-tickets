CREATE TABLE IF NOT EXISTS airlines
(
    id              BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    airline_name    VARCHAR(45) NOT NULL,
    contact_number  VARCHAR(45) NOT NULL,
    airline_website VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS flights
(
    id             BIGINT         NOT NULL GENERATED ALWAYS AS IDENTITY,
    departure      VARCHAR(45)    NOT NULL,
    destination    VARCHAR(45)    NOT NULL,
    departure_time TIMESTAMP(0)   NOT NULL,
    arrival_time   TIMESTAMP(0)   NOT NULL,
    ticket_price   DECIMAL(10, 0) NOT NULL,
    airlines_id    BIGINT         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_flights_airlines1
        FOREIGN KEY (airlines_id)
            REFERENCES airlines (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS passengers
(
    id             BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    passenger_name VARCHAR(45) NOT NULL,
    passenger_age  INT         NOT NULL,
    gender         VARCHAR(45) NOT NULL,
    customers_id   BIGINT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_passengers_customers1
        FOREIGN KEY (customers_id)
            REFERENCES customers (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS bookings
(
    id             BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    booking_date   DATE        NOT NULL,
    payment_status VARCHAR(45) NOT NULL,
    flights_id     BIGINT      NOT NULL,
    passengers_id  BIGINT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_bookings_flights1
        FOREIGN KEY (flights_id)
            REFERENCES flights (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_bookings_passengers1
        FOREIGN KEY (passengers_id)
            REFERENCES passengers (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);