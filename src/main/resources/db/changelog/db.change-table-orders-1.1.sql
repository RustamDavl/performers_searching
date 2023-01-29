--liquibase formatted sql

--changeset RustDv:1
alter table orders
    add column start_at date;

--changeset RustDv:2
alter table orders
add column name varchar(60);

--changeset RustDv:3
alter table orders
drop column end_at;

--changeset RustDv:4
alter table orders
add column end_at date;

