CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP    DEFAULT NOW(),
    updated_at  TIMESTAMP    DEFAULT NOW(),
    created_by VARCHAR(255) DEFAULT NULL,
    updated_by  VARCHAR(255) DEFAULT NULL,
    version    int          DEFAULT 0
);


