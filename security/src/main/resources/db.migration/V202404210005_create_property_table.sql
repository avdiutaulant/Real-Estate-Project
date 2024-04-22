CREATE TABLE property
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    address_id  INTEGER,
    type        VARCHAR(255),
    price       DOUBLE PRECISION                         NOT NULL,
    size        DOUBLE PRECISION                         NOT NULL,
    bedrooms    INTEGER                                  NOT NULL,
    bathrooms   INTEGER                                  NOT NULL,
    amenities   VARCHAR(255),
    description VARCHAR(255),
    status      VARCHAR(255),
    agent_id    INTEGER,
    images      VARCHAR(255),
    created_at  date,
    CONSTRAINT pk_property PRIMARY KEY (id)
);

ALTER TABLE property
    ADD CONSTRAINT uc_property_address UNIQUE (address_id);

ALTER TABLE property
    ADD CONSTRAINT FK_PROPERTY_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE property
    ADD CONSTRAINT FK_PROPERTY_ON_AGENT FOREIGN KEY (agent_id) REFERENCES agent (id);