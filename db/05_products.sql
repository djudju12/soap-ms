CREATE DATABASE products;

\c products;

CREATE TABLE tb_products(
    id SERIAL PRIMARY KEY
    , name varchar(255) NOT NULL
    , description text NOT NULL
    , price numeric(10,2) NOT NULL
)
