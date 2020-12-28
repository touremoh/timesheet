drop schema timesheet_o2xp cascade;
create schema timesheet_o2xp;

create table if not exists timesheet_o2xp.user_profile (
   id bigint primary key,
   first_name varchar(255),
   last_name varchar(255),
   username varchar(255),
   password varchar(255) unique,
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.customer (
   id bigint primary key,
   name varchar(255),
   reference varchar(255) unique,
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.tasks (
   id bigint primary key,
   name varchar(255),
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.day_type (
   id bigint primary key,
   name varchar(255),
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.contract (
   id bigint primary key,
   starting_dt date,
   ending_dt date,
   customer_id integer,
   user_id integer,
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.project (
   id bigint primary key,
   name varchar(255),
   description varchar(255),
   starting_dt date,
   ending_dt date,
   contract_id integer,
   created_at timestamp,
   updated_at timestamp
);

create table if not exists timesheet_o2xp.input_time (
   id bigint primary key,
   duration integer,
   working_dt date,
   project_id integer,
   task_id integer,
   user_id integer,
   day_type_id integer,
   created_at timestamp,
   updated_at timestamp
);

alter table timesheet_o2xp.contract
    add constraint fk_contract_user_id foreign key (user_id) references timesheet_o2xp.user_profile(id),
    add constraint fk_contract_customer_id foreign key (customer_id) references timesheet_o2xp.customer(id);

alter table timesheet_o2xp.project
    add constraint fk_project_contract_id foreign key (contract_id) references timesheet_o2xp.contract(id);

alter table timesheet_o2xp.input_time
    add constraint fk_input_time_user_id foreign key (user_id) references timesheet_o2xp.user_profile(id),
    add constraint fk_input_time_task_id foreign key (task_id) references timesheet_o2xp.tasks(id),
    add constraint fk_input_time_day_type foreign key (day_type_id) references timesheet_o2xp.day_type(id),
    add constraint fk_input_time_project_id foreign key (project_id) references timesheet_o2xp.project(id);





