--liquibase formatted sql

--changeset Sabir:1
create table contact
(
    name           varchar(20)                             NOT NULL,
    surname        varchar(20)                             NOT NULL,
    age            int CHECK (age >= 0) CHECK (age <= 100) NOT NULL,
    phone_number   varchar(20) UNIQUE,
    city_of_living varchar(20),
    PRIMARY KEY (name, surname, age)
);
--rollback drop table contact;

--changeset Sabir:2
insert into contact (name, surname, age, phone_number, city_of_living)
VALUES ('Vladimir', 'Max', 35, 89999998877, 'MOSCOW');

insert into contact (name, surname, age, phone_number, city_of_living)
VALUES ('Ola', 'Min', 28, 89999998876, 'PITER');

insert into contact (name, surname, age, phone_number, city_of_living)
VALUES ('Sabir', 'Bishop', 25, 89999998875, 'MOSCOW');
--rollback drop values from table CUSTOMERS;