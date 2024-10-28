CREATE TABLE IF NOT EXISTS customers
(
    id      BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    name    VARCHAR(45) NOT NULL,
    email   VARCHAR(45) NOT NULL,
    phone   VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

create table roles
(
    id bigint generated always as identity primary key not null,
    name varchar(100)
);

create table roles_has_customers
(
    id bigint generated always as identity primary key not null,
    customer_id bigint,
    role_id bigint
);

ALTER TABLE roles_has_customers
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (customer_id) REFERENCES customers(id);

ALTER TABLE roles_has_customers
    ADD CONSTRAINT fk_role_id
        FOREIGN KEY (role_id) REFERENCES roles(id);


INSERT INTO customers (name, email, phone, address, password) VALUES ('shede', 'shede14@outlook.com', '+1234567890', 'admin address', 'admin');
INSERT INTO customers (name, email, phone, address, password) VALUES ('test', 'test@email.com', '+1111111111', 'test address', 'test');

INSERT INTO roles (name) VALUES ('ROLE_User');
INSERT INTO roles (name) VALUES ('ROLE_Admin');

INSERT INTO roles_has_customers (customer_id, role_id) VALUES (1, 1);
INSERT INTO roles_has_customers (customer_id, role_id) VALUES (1, 2);
INSERT INTO roles_has_customers (customer_id, role_id) VALUES (2, 1);