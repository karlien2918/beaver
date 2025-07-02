CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP    DEFAULT NOW(),
    updated_at TIMESTAMP    DEFAULT NOW(),
    created_by VARCHAR(255) DEFAULT NULL,
    updated_by VARCHAR(255) DEFAULT NULL,
    version    int          DEFAULT 0
);

CREATE TABLE IF NOT EXISTS outbox
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP    DEFAULT NOW(),
    updated_at TIMESTAMP    DEFAULT NOW(),
    created_by VARCHAR(255) DEFAULT NULL,
    updated_by VARCHAR(255) DEFAULT NULL,
    version    int          DEFAULT 0
);


CREATE TABLE IF NOT EXISTS payment
(
    id         SERIAL PRIMARY KEY,
    trace_id   varchar(255) DEFAULT NOT NULL,
    status     VARCHAR(10)  DEFAULT NOT NULL,
    email      VARCHAR(255) DEFAULT NOT NULL,
    order_id   VARCHAR(255) UNIQUE NOT NULL,
    price      int          DEFAULT NOT NULL,
    created_at TIMESTAMP    DEFAULT NOW(),
    updated_at TIMESTAMP    DEFAULT NOW(),
    created_by VARCHAR(255) DEFAULT NULL,
    updated_by VARCHAR(255) DEFAULT NULL,
    version    int          DEFAULT 0
);
