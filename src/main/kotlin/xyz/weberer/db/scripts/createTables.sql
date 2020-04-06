CREATE TABLE product (
    id              SERIAL      NOT NULL,
    product_id      INTEGER     NOT NULL UNIQUE,
    product_name    TEXT        NOT NULL,
    category_name   TEXT        NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk_id PRIMARY KEY (id);

CREATE TABLE part (
    id                          SERIAL          NOT NULL,
    punctuated_part_number      VARCHAR(9)      NOT NULL,
    description                 TEXT            NOT NULL,
    product_id                  INTEGER         NOT NULL,
    original_retail_price       NUMERIC(10, 2)  NOT NULL,
    brand_name                  TEXT            NOT NULL,
    asset_url                   TEXT            NOT NULL
);

ALTER TABLE part
    ADD CONSTRAINT part_pk_id PRIMARY KEY (id),
    ADD CONSTRAINT part_fk_prodid FOREIGN KEY (product_id) REFERENCES product(product_id);
