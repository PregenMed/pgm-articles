CREATE SCHEMA IF NOT EXISTS pgmarticle;

CREATE TABLE IF NOT EXISTS article(
    id          BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    uuid        UUID UNIQUE,
    title       VARCHAR(255),
    author_uuid UUID,
    content     VARCHAR(10000),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT  pk_article PRIMARY KEY (id)
);
CREATE INDEX IF NOT EXISTS idx_uuid ON article (uuid);
CREATE INDEX IF NOT EXISTS idx_author_uuid ON article (author_uuid);
CREATE INDEX IF NOT EXISTS idx_article_title_fulltext_eng ON article USING GIST (to_tsvector('english', title));

