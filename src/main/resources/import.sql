-- bootstrap initial admin account
insert into app_user (id, email, password, role, first_name, last_name) values (0, 'g.adam@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'ADMIN', 'Godra', 'Adam');
insert into app_user (id, email, password, role, first_name, last_name) values (1, 'g.adam2@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'USER', 'Godra', 'Adam');
insert into device (id, address, avg_consumption, max_consumption, description, user_id) values(0, 'Example address', 0, 12000, 'Example device', 0)