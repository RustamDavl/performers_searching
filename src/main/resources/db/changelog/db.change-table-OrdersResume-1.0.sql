--liquibase formatted sql

--changeset RustDv:1
alter table orders_resume
drop constraint orders_resume_order_status_check;

--changeset RustDv:2
alter table orders_resume
drop constraint orders_resume_resume_status_check;