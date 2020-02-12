-- SCHEMA: party
-- DROP SCHEMA party IF EXISTS CASCADE;

CREATE SCHEMA party
    AUTHORIZATION vicko_admin;

COMMENT ON SCHEMA party
    IS 'contains user data';
    
-- SCHEMA: jokes
-- DROP SCHEMA jokes IF EXISTS CASCADE;

CREATE SCHEMA jokes
    AUTHORIZATION vicko_admin;

COMMENT ON SCHEMA jokes
    IS 'contains bad jokes';