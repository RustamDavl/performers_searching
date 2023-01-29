--liquibase formatted sql

--changeset RustDv:1
alter table resume
drop column experience;

--changeset RustDv:2
alter table resume
add column experience_id int references experience(id);