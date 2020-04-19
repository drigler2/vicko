-- SCHEMA: jokes
-- DROP SCHEMA jokes IF EXISTS CASCADE;

CREATE SCHEMA jokes
    AUTHORIZATION vicko_admin;

COMMENT ON SCHEMA jokes
    IS 'contains bad jokes';