-- categories
CREATE TABLE jokes.category
(
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(100) NOT NULL
);

ALTER TABLE jokes.category
    OWNER to vicko_admin;
COMMENT ON TABLE jokes.category
    IS 'possible categories of bad jokes';

-- jokes actual
CREATE TABLE jokes.joke
(
    id SERIAL PRIMARY KEY,
    id_category INTEGER REFERENCES jokes.category(id) NOT NULL, 
    -- anything longer than that cannot possibly be a joke
    content CHARACTER VARYING(500) NOT NULL,
    likes INTEGER DEFAULT 0,
    dislikes INTEGER DEFAULT 0
);

ALTER TABLE jokes.category
    OWNER to vicko_admin;
COMMENT ON TABLE jokes.category
    IS 'bad jokes';
    