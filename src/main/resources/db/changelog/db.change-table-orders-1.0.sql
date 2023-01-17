--liquibase formatted sql

--changeset RustDv:1
alter table orders
drop column start_at;
