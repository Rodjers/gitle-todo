CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "ltree";

CREATE TABLE label (
  id UUID PRIMARY KEY,
  "user" UUID,
  name VARCHAR(255),
  path ltree
);

CREATE TABLE task (
  id UUID PRIMARY KEY,
  title VARCHAR(255)
);

INSERT INTO task values (uuid_generate_v4(), 'Task 1');