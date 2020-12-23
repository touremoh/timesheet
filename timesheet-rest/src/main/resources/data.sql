-- NOTE: the password below is temporary. In production, only an encrypted password should be stored

-- USER
insert into public."UserProfile" ("id", "firstName", "lastName", "password", "createdAt", "updatedAt")
values (1, 'Mohamed', 'Toure', 'mt123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into public."UserProfile" ("id", "firstName", "lastName", "password", "createdAt", "updatedAt")
values (2, 'Jean Michel', 'Delseaux', 'jm123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into public."UserProfile" ("id", "firstName", "lastName", "password", "createdAt", "updatedAt")
values (3, 'Arnaud', 'Cordier', 'ac123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));


-- CUSTOMER
insert into public."Customer" (id, name, reference, "createdAt", "updatedAt")
values (1, 'Clearstream', 'CS12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into public."Customer" (id, name, reference, "createdAt", "updatedAt")
values (2, 'DRI', 'DR12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into public."Customer" (id, name, reference, "createdAt", "updatedAt")
values (3, 'BEI', 'BE12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
