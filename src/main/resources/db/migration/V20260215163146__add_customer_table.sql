CREATE TABLE customer (
    email_address   VARCHAR(100)    NOT NULL PRIMARY KEY ,
    first_name      VARCHAR(50)     NOT NULL,
    last_name       VARCHAR(50)     NOT NULL,
    birth_date      DATE            NOT NULL,
    mobile_no       BIGINT          NOT NULL
);

CREATE TABLE address (
    id              UUID            NOT NULL PRIMARY KEY,
    address_line1   VARCHAR(70)     NOT NULL,
    address_line2   VARCHAR(70)             ,
    address_line3   VARCHAR(70)             ,
    city            VARCHAR(70)     NOT NULL,
    zip_code        VARCHAR(10)     NOT NULL,
    country         VARCHAR(70)     NOT NULL
);

CREATE TABLE customer_address (
      address_id    UUID            NOT NULL,
      customer_id   VARCHAR(100)    NOT NULL,
      PRIMARY KEY (address_id, customer_id),
      FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE,
      FOREIGN KEY (customer_id) REFERENCES customer (email_address) ON DELETE CASCADE
);

CREATE INDEX idx_customer_address_customer_id ON customer_address (customer_id);
CREATE INDEX idx_customer_address_address_id ON customer_address (address_id);
