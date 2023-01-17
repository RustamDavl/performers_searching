--liquibase formatted sql

--changeset RustDv:1
alter table orders
    add column start_at date;

--changeset RustDv:2
alter table orders
add column name varchar(60);
