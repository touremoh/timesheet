-- NOTE: the password below is temporary. In production, only an encrypted password should be stored

-- USER
insert into timesheet_o2xp.user_profile (id, first_name, last_name, username, password, created_at, updated_at)
values (1, 'Mohamed', 'Toure', 'mtoure', 'mt123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into timesheet_o2xp.user_profile (id, first_name, last_name, username, password, created_at, updated_at)
values (2, 'Jean Michel', 'Delseaux', 'jmdelseaux', 'jm123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into timesheet_o2xp.user_profile (id, first_name, last_name, username, password, created_at, updated_at)
values (3, 'Arnaud', 'Cordier', 'acordier', 'ac123', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));


-- CUSTOMER
insert into timesheet_o2xp.customer (id, name, reference, created_at, updated_at)
values (1, 'Clearstream', 'CS12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into timesheet_o2xp.customer (id, name, reference, created_at, updated_at)
values (2, 'DRI', 'DR12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
insert into timesheet_o2xp.customer (id, name, reference, created_at, updated_at)
values (3, 'BEI', 'BE12345', to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'), to_timestamp('2020-12-22 12:30:20', 'YYYY-MM-DD HH:MI:SS'));
