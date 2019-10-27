-- Survey table

CREATE TABLE survey (

    id uuid,
    name text NOT NULL,
    description text NOT NULL,

    PRIMARY KEY (id)
);

CREATE INDEX survey_name ON survey USING btree (name);
CREATE INDEX survey_description ON survey USING btree (description);


-- Question table

CREATE TABLE question (

    id uuid,
    text text NOT NULL,
    type varchar(40) NOT NULL,
    survey_id uuid NOT NULL REFERENCES survey(id),
    correct_option_id uuid NULL,

    PRIMARY KEY (id)
);

CREATE INDEX question_text ON question USING btree (text);

-- Option table

CREATE TABLE option (

    id uuid,
    text text NOT NULL,
    score integer NOT NULL,
    question_id uuid NOT NULL REFERENCES question(id),

    PRIMARY KEY (id)
);

CREATE INDEX option_text ON option USING btree (text);