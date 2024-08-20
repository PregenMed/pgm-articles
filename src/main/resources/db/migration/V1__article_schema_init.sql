CREATE TABLE IF NOT EXISTS article
(
    id          INTEGER NOT NULL,
    uuid        UUID,
    title       VARCHAR(255),
    author_uuid UUID,
    content     VARCHAR(10000),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_article PRIMARY KEY (id)
);