INSERT INTO USER (name, email, password)
VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$chmz4fWdlex2XmG14.ZM8ulUZEl5GZ/lH7lKIx.GnUu/uJMcnjr/m');
INSERT INTO USER (name, email, password)
VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO ROLE (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO ROLE (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);