create table if not exists public."UserProfile" (
                                                    "id" integer primary key,
                                                    "firstName" varchar(250),
                                                    "lastName" varchar(250),
                                                    "password" varchar(250) unique,
                                                    "createdAt" timestamp,
                                                    "updatedAt" timestamp
);

create table if not exists public."Customer" (
                                                 "id" integer primary key,
                                                 "name" varchar(250),
                                                 "reference" varchar(250) unique,
                                                 "createdAt" timestamp,
                                                 "updatedAt" timestamp
);

create table if not exists public."Tasks" (
                                              "id" integer primary key,
                                              "name" varchar(250),
                                              "createAt" timestamp,
                                              "updatedAt" timestamp
);

create table if not exists public."DayType" (
                                                "id" integer primary key,
                                                "name" varchar(250),
                                                "createdAt" timestamp,
                                                "updatedAt" timestamp
);

create table if not exists public."Contract" (
                                                 "id" integer primary key,
                                                 "startingDt" date,
                                                 "endingDt" date,
                                                 "customerId" integer,
                                                 "userId" integer,
                                                 "createdAt" timestamp,
                                                 "updatedAt" timestamp
);

create table if not exists public."Project" (
                                                "id" integer primary key,
                                                "name" varchar(250),
                                                "description" varchar(250),
                                                "startingDt" date,
                                                "endingDt" date,
                                                "contractId" integer,
                                                "createdAt" timestamp,
                                                "updatedAt" timestamp
);

create table if not exists public."InputTime" (
                                                  "id" integer primary key,
                                                  "duration" integer,
                                                  "workingDt" date,
                                                  "projectId" integer,
                                                  "taskId" integer,
                                                  "userId" integer,
                                                  "dayTypeId" integer,
                                                  "createdAt" timestamp,
                                                  "updatedAt" timestamp
);

alter table public."Contract"
    add constraint "fk_contract_userId" foreign key ("userId") references public."UserProfile"(id),
    add constraint "fk_contract_customerId" foreign key ("customerId") references public."Customer"(id);

alter table public."Project"
    add constraint "fk_project_contractId" foreign key ("contractId") references public."Contract"(id);

alter table public."InputTime"
    add constraint "fk_input_time_userId" foreign key ("userId") references public."UserProfile"(id),
    add constraint "fk_input_time_taskId" foreign key ("taskId") references public."Tasks"(id),
    add constraint "fk_input_time_dayType" foreign key ("dayTypeId") references public."DayType"(id),
    add constraint "fk_input_time_projectId" foreign key ("projectId") references public."Project"(id);





