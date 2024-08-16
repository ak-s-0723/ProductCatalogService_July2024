CREATE TABLE category
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jc_instructor
(
    user_id BIGINT NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_jc_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jc_mentor
(
    user_id         BIGINT NOT NULL,
    number_of_hours INT NULL,
    CONSTRAINT pk_jc_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jc_ta
(
    user_id BIGINT NOT NULL,
    ratings DOUBLE NULL,
    CONSTRAINT pk_jc_ta PRIMARY KEY (user_id)
);

CREATE TABLE jc_user
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_jc_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    number_of_hours INT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    ratings DOUBLE NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price DOUBLE NULL,
    image_url       VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id              BIGINT NOT NULL,
    user_type       INT NULL,
    name            VARCHAR(255) NULL,
    company         VARCHAR(255) NULL,
    ratings DOUBLE NULL,
    number_of_hours INT NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE test_model
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    CONSTRAINT pk_testmodel PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    number_of_hours INT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    ratings DOUBLE NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jc_instructor
    ADD CONSTRAINT FK_JC_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jc_user (id);

ALTER TABLE jc_mentor
    ADD CONSTRAINT FK_JC_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jc_user (id);

ALTER TABLE jc_ta
    ADD CONSTRAINT FK_JC_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jc_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);