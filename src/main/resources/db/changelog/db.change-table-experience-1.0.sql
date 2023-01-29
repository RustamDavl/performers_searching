--liquibase formatted sql

--changeset RustDv:1
alter table experience
drop column resume_id;