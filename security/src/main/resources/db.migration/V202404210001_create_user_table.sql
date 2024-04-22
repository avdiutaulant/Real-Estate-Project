CREATE TABLE _user
(
    id        SERIAL      NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL,
    CONSTRAINT pk__user PRIMARY KEY (id)
);

ALTER TABLE _user
    ADD CONSTRAINT uc__user_email UNIQUE (email);

INSERT INTO _user (firstname, lastname, email, password, role)
VALUES ('Filan', 'Fisteku', 'filan.fisteku@example.com', 'password', 'ADMIN');