# Task Steps Schema

# --- !Ups
create table if not exists task_steps(
    id serial primary key,
    name text not null,
    note text default null,
    created_on timestamp not null default current_timestamp
);

# --- !Downs
drop table if exists task_steps;