-- Survey_answers table

CREATE TABLE survey_answers (

    survey_id uuid NOT NULL REFERENCES survey(id),
    question_id uuid NOT NULL REFERENCES question(id),
    option_id uuid NOT NULL REFERENCES option(id),
    user_id uuid NOT NULL,

    PRIMARY KEY (survey_id, question_id, option_id, user_id)
);