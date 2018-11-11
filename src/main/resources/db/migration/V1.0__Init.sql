CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "ltree";

CREATE TABLE label (
  id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
  "user" UUID,
  path ltree
);

CREATE TABLE task (
  id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
  title VARCHAR
)
