--liquibase formatted sql

--changeset RustamDv:1
CREATE TABLE IF NOT EXISTS person
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(50)  not null,
    email      varchar(128) NOT NULL unique,
    password   varchar(128) NOT NULL,
    photo      text
);

--changeset RustamDv:2
CREATE TABLE IF NOT EXISTS role
(
    id   serial PRIMARY KEY,
    name varchar(10) CHECK (name in ('CUSTOMER',
                                     'EXECUTOR'))
);

--changeset RustamDv:3
CREATE TABLE IF NOT EXISTS person_role
(
    id        serial primary key,
    person_id int REFERENCES person (id) ON DELETE CASCADE not null,
    role_id   int REFERENCES role (id) ON DELETE CASCADE   not null,
    rating    numeric(2, 1),
    comment   text,
    unique (person_id, role_id)
);

--changeset RustamDv:4
CREATE TABLE IF NOT EXISTS keyword
(
    id   serial PRIMARY KEY,
    name varchar(50) NOT NULL
);

--changeset RustamDv:5
CREATE TABLE IF NOT EXISTS orders
(
    id           serial PRIMARY KEY,
    person_id    int references person (id) on delete cascade not null,
    city         varchar(60),
    street       varchar(60),
    house_number varchar(60),
    description  text                                         NOT NULL,
    keyword_id   int REFERENCES keyword (id)                  NOT NULL,
    start_at     time                                         not null,
    end_at       time                                         not null
);

--changeset RustamDv:6
CREATE TABLE IF NOT EXISTS measurement
(
    id   serial PRIMARY KEY,
    name varchar(25) NOT NULL UNIQUE
);


--changeset RustamDv:7
CREATE TABLE IF NOT EXISTS resume
(
    id             serial PRIMARY KEY,
    person_id      int references person (id) on delete cascade      not null,
    keyword_id     int REFERENCES keyword (id) on delete cascade     NOT NULL,
    price          int                                               NOT NULL,
    measurement_id int REFERENCES measurement (id) on delete cascade NOT NULL,
    mon            bool                                              not null   default false,
    tues           bool                                              not null   default false,
    wed            bool                                              not null   default false,
    thurs          bool                                              not null   default false,
    fri            bool                                              not null   default false,
    sat            bool                                              not null   default false,
    sun            bool                                              not null   default false,
    start_at       TIME                                              NOT NULL,
    end_at         TIME                                              NOT NULL,
    experience     varchar(60)                                       NOT NULL,
    city           varchar(60),
    street         varchar(60),
    house_number   varchar(40),
    team           varchar(30) check ( team in ('ALONE', 'ALONE_TEAM', 'TEAM')) DEFAULT 'ALONE_TEAM' NOT NULL,
    about_me       text

);


--changeset RustamDv:8
CREATE TABLE IF NOT EXISTS orders_resume
(
    id            serial primary key,
    order_id      int                                                NOT NULL REFERENCES orders (id) on delete cascade,
    resume_id     int                                                NOT NULL REFERENCES resume (id) on delete cascade,
    resume_status varchar(20) CHECK (resume_status in ('SENT',
                                                       'VIEWED',
                                                       'ACCEPTED',
                                                       'NOT_VIEWED',
                                                       'REFUSED'))   NOT NULL,
    order_status  varchar(20) CHECK (order_status in ('SENT',
                                                      'VIEWED',
                                                      'ACCEPTED',
                                                      'REFUSED',
                                                      'NOT_VIEWED')) NOT NULL,
    UNIQUE (order_id, resume_id)
);

--changeset RustamDv:9
create table if not exists photo_f_resume
(
    id        serial primary key,
    resume_id int not null references resume (id) on delete cascade,
    photo     text

);

--changeset RustamDv:10
create table if not exists photo_f_orders
(
    id       serial primary key,
    order_id int not null references orders (id) on delete cascade,
    photo    text
);


