# Tasks Schema

# --- !Ups
create table if not exists tasks(
    id serial primary key,
    name text not null,
    created_on timestamp not null default current_timestamp
);

# --- !Downs
drop table if exists tasks;