CREATE TYPE status_enum AS ENUM ('DRAFT', 'PUBLISHED', 'ARCHIVED', 'DELETED');
ALTER TABLE pgmarticle.article
    ADD COLUMN status status_enum NOT NULL DEFAULT 'DRAFT';