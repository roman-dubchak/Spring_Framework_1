create table if not exists product
(
    id
    serial
    primary
    key,
    title
    VARCHAR
(
    255
) NOT NULL,
    price INT NOT NULL
    )