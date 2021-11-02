-- bootstrap initial admin account
insert into app_user (id, email, password, role) values (1, 'g.adam@throwaway.com', '$2a$12$.tyUWmptZ1IXUPNUEsO3jO9F/u5D0LKdMWq6KM796DOifqHQcE33.', 'ADMIN');