--liquibase formatted sql

--changeset RustDv:1
create table experience
(
    id        serial primary key,
    name      varchar(25)                                  not null unique,
    resume_id int references resume (id) on delete cascade not null
)