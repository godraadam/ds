-- bootstrap initial admin account
insert into app_user (id, email, password, role, first_name, last_name) values (0, 'g.adam@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'ADMIN', 'Godra', 'Adam');