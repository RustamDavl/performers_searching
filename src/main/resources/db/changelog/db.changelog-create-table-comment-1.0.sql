--liquibase formatted sql

--changeset RustDv:1
create table comment
(
    id           serial primary key,
    comment      varchar(3000) not null,
    recipient_id int references person (id) on delete cascade,
    sender_id    int references person (id) on delete cascade
);