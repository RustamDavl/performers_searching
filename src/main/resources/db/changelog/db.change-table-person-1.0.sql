--liquibase formatted sql

--changeset RustDv:1
alter table person
add column personal_info text