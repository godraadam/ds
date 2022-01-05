-- bootstrap initial admin account
insert into app_user (id, email, password, role, first_name, last_name, address) values (0, 'g.adam@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'ADMIN', 'Godra', 'Adam', 'Cluj-Napoca Str. Gh. Baritiu nr 1');
insert into app_user (id, email, password, role, first_name, last_name, address) values (1, 'g.adam2@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'USER', 'Godra', 'Adam the II', 'Cluj-Napoca Str. Gh. Baritiu nr 1');
insert into sensor (id, description, max_value) values (0, 'Example Sensor', 14000)
insert into sensor (id, description, max_value) values (1, 'Example Sensor 2', 15000)
insert into device (id, address, avg_consumption, max_consumption, description, user_id, sensor_id) values(0, 'Example address', 0, 12000, 'Example device', 0, 0)
insert into device (id, address, avg_consumption, max_consumption, description, user_id, sensor_id) values(1, 'Example address 2', 0, 14000, 'Example device 2', 1, 1)
