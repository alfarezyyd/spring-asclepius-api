DROP DATABASE spring_asclepius_api;
CREATE DATABASE spring_asclepius_api;
USE spring_asclepius_api;

CREATE TABLE addresses
(
    id                   BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    urban_village_name   VARCHAR(100)                               NOT NULL,
    sub_district_name    VARCHAR(100)                               NOT NULL,
    district_name        VARCHAR(100)                               NOT NULL,
    province_name        VARCHAR(100)                               NOT NULL,
    neighbourhood_number VARCHAR(5)                                 NOT NULL,
    hamlet_number        VARCHAR(5)                                 NOT NULL,
    postal_code          VARCHAR(5)                                 NOT NULL
);

CREATE TABLE people
(
    people_id            BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                  NOT NULL,
    address_id           BIGINT UNSIGNED UNIQUE                                                      NOT NULL,
    identity_card_number VARCHAR(20) UNIQUE                                                          NOT NULL,
    identity_card_type   ENUM ('IDENTITY_CARD', 'DRIVING_LICENSE')                                   NOT NULL,
    full_name            VARCHAR(50)                                                                 NOT NULL,
    email                VARCHAR(100) UNIQUE                                                         NOT NULL,
    gender               ENUM ('MAN', 'WOMAN')                                                       NOT NULL,
    religion             ENUM ('MUSLIM', 'CHRISTIAN', 'CATHOLIC','HINDU', 'BUDDHIST', 'KONG_HU_CHU') NOT NULL,
    blood_type           ENUM ('A', 'B', 'O', 'AB')                                                  NOT NULL,
    birth_place          VARCHAR(50)                                                                 NOT NULL,
    birth_date           DATE                                                                        NOT NULL,
    age                  TINYINT UNSIGNED                                                            NOT NULL,
    marital_status       ENUM ('MARRIED', 'NOT_MARRIED_YET')                                         NOT NULL,
    last_education       ENUM ('ELEMENTARY_SCHOOL', 'JUNIOR_HIGH_SCHOOL', 'SENIOR_OR_VOCATIONAL_SCHOOL', 'DIPLOMA_3', 'BACHELOR_DEGREE', 'ASSOCIATE_DEGREE', 'MASTER_DEGREE'),
    telephone_number     VARCHAR(15),
    CONSTRAINT fk_people_addresses FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE doctors
(
    people_id              BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    code                   VARCHAR(16) UNIQUE          NOT NULL,
    alumnus                VARCHAR(100)                NOT NULL,
    practice_permit_number VARCHAR(30)                 NOT NULL,
    CONSTRAINT fk_doctors_people FOREIGN KEY (people_id) REFERENCES people (people_id)
);

CREATE TABLE polyclinics
(
    code     VARCHAR(16) PRIMARY KEY NOT NULL,
    name     VARCHAR(100)            NOT NULL,
    location VARCHAR(50)             NOT NULL,
    note     TEXT
);

CREATE TABLE specialities
(
    code VARCHAR(16) PRIMARY KEY NOT NULL,
    name VARCHAR(100)            NOT NULL,
    note TEXT
);

CREATE TABLE doctors_polyclinics
(
    doctor_id       BIGINT UNSIGNED NOT NULL,
    polyclinic_code VARCHAR(16)     NOT NULL,
    UNIQUE (doctor_id, polyclinic_code),
    CONSTRAINT fk_doctors_polyclinics_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (people_id),
    CONSTRAINT fk_doctors_polyclinics_polyclinics FOREIGN KEY (polyclinic_code) REFERENCES polyclinics (code)
);

CREATE TABLE doctors_specialities
(
    doctor_id       BIGINT UNSIGNED NOT NULL,
    speciality_code VARCHAR(16)     NOT NULL,
    UNIQUE (doctor_id, speciality_code),
    CONSTRAINT fk_doctors_specialities_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (people_id),
    CONSTRAINT fk_doctors_specialities_specialities FOREIGN KEY (speciality_code) REFERENCES specialities (code)
);

CREATE TABLE ethnicities
(
    id   SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    type ENUM ('ETHNIC', 'NATIONALITY')               NOT NULL,
    name VARCHAR(50)                                  NOT NULL
);

CREATE TABLE languages
(
    id   SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(50) UNIQUE                           NOT NULL
);

CREATE TABLE disabilities
(
    id   SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(50)                                  NOT NULL UNIQUE
);

CREATE TABLE insurances
(
    code             VARCHAR(16) PRIMARY KEY NOT NULL,
    name             VARCHAR(100)            NOT NULL,
    company          VARCHAR(100)            NOT NULL,
    telephone_number VARCHAR(15)             NOT NULL,
    representative   VARCHAR(50)             NOT NULL
);

CREATE TABLE instances
(
    code             VARCHAR(16) PRIMARY KEY NOT NULL,
    address_id       BIGINT UNSIGNED UNIQUE  NOT NULL,
    name             VARCHAR(100)            NOT NULL,
    telephone_number VARCHAR(15)             NOT NULL,
    CONSTRAINT fk_instances_addresses FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE custodians
(
    people_id BIGINT UNSIGNED PRIMARY KEY                                                NOT NULL,
    relation  ENUM ('FATHER', 'MOTHER','WIFE','HUSBAND','SIBLING','CHILD','SELF','MISC') NOT NULL,
    job       VARCHAR(50)                                                                NOT NULL,
    CONSTRAINT fk_custodians_people FOREIGN KEY (people_id) REFERENCES people (people_id)
);

CREATE TABLE patients
(
    people_id           BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    medical_record_code VARCHAR(128) UNIQUE         NOT NULL,
    ethnic_id           SMALLINT UNSIGNED           NOT NULL,
    custodian_id        BIGINT UNSIGNED             NOT NULL,
    instance_code       VARCHAR(16),
    mother_name         VARCHAR(50)                 NOT NULL,
    registration_date   DATE                        NOT NULL,
    job                 VARCHAR(50)                 NOT NULL,
    employee_code       VARCHAR(50),
    CONSTRAINT fk_patients_people FOREIGN KEY (people_id) REFERENCES people (people_id),
    CONSTRAINT fk_patients_custodians FOREIGN KEY (custodian_id) REFERENCES custodians (people_id),
    CONSTRAINT fk_patients_instances FOREIGN KEY (instance_code) REFERENCES instances (code),
    CONSTRAINT fk_patients_ethnicities FOREIGN KEY (ethnic_id) REFERENCES ethnicities (id)
);


CREATE TABLE patients_disabilities
(
    patient_id      BIGINT UNSIGNED   NOT NULL,
    disabilities_id SMALLINT UNSIGNED NOT NULL,
    UNIQUE (patient_id, disabilities_id),
    CONSTRAINT fk_patients_disabilities_patients FOREIGN KEY (patient_id) REFERENCES patients (people_id),
    CONSTRAINT fk_patients_disabilities_disabilities FOREIGN KEY (disabilities_id) REFERENCES disabilities (id)
);

CREATE TABLE patients_insurances
(
    patient_id     BIGINT UNSIGNED NOT NULL,
    insurance_code VARCHAR(16)     NOT NULL,
    UNIQUE (patient_id, insurance_code),
    CONSTRAINT fk_patients_insurances_patients FOREIGN KEY (patient_id) REFERENCES patients (people_id),
    CONSTRAINT fk_patients_insurances_insurances FOREIGN KEY (insurance_code) REFERENCES insurances (code)
);

CREATE TABLE patients_languages
(
    patient_id  BIGINT UNSIGNED   NOT NULL,
    language_id SMALLINT UNSIGNED NOT NULL,
    UNIQUE (patient_id, language_id),
    CONSTRAINT fk_patients_languages_patients FOREIGN KEY (patient_id) REFERENCES patients (people_id),
    CONSTRAINT fk_patients_languages_languages FOREIGN KEY (language_id) REFERENCES languages (id)
);

SELECT *
FROM polyclinics;
SELECT *
FROM doctors_polyclinics;
SELECT *
FROM doctors_specialities;
SELECT *
FROM specialities;
SELECT *
FROM people;
SELECT *
FROM addresses;
SELECT *
FROM doctors;