DROP DATABASE spring_asclepius_api;
CREATE DATABASE spring_asclepius_api;
USE spring_asclepius_api;

CREATE TABLE addresses
(
    id                   BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    urban_village_name   VARCHAR(100)                NOT NULL,
    sub_district_name    VARCHAR(100)                NOT NULL,
    district_name        VARCHAR(100)                NOT NULL,
    province_name        VARCHAR(100)                NOT NULL,
    neighbourhood_number VARCHAR(5)                  NOT NULL,
    hamlet_number        VARCHAR(5)                  NOT NULL,
    postal_code          VARCHAR(5)                  NOT NULL
);

CREATE TABLE people
(
    id                        BIGINT UNSIGNED PRIMARY KEY                                      NOT NULL,
    address_id                BIGINT UNSIGNED UNIQUE                                           NOT NULL,
    identity_card_number      VARCHAR(20)                                                      NOT NULL,
    identity_card_number_type ENUM ('Identity Card', 'Driving License')                        NOT NULL,
    full_name                 VARCHAR(50)                                                      NOT NULL,
    email                     VARCHAR(100) UNIQUE                                              NOT NULL,
    gender                    ENUM ('Man', 'Woman')                                            NOT NULL,
    religion                  ENUM ('Muslim', 'Christian', 'Hindu', 'Buddhist', 'Kong Hu Chu') NOT NULL,
    blood_type                ENUM ('A', 'B', 'C', 'AB')                                       NOT NULL,
    birth_place               VARCHAR(50)                                                      NOT NULL,
    birth_date                DATE                                                             NOT NULL,
    age                       SMALLINT UNSIGNED                                                NOT NULL,
    marital_status            ENUM ('Married', 'Not Married')                                  NOT NULL,
    telephone_number          VARCHAR(15),
    CONSTRAINT fk_people_addresses FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE doctors
(
    code                   VARCHAR(16) PRIMARY KEY                                       NOT NULL,
    people_id              BIGINT UNSIGNED                                               NOT NULL,
    special_code           VARCHAR(16)                                                   NOT NULL,
    last_education         ENUM ('Bachelor Degree', 'Associate Degree', 'Master Degree') NOT NULL,
    alumnus                VARCHAR(100)                                                  NOT NULL,
    practice_permit_number VARCHAR(30)                                                   NOT NULL,
    CONSTRAINT fk_doctors_people FOREIGN KEY (people_id) REFERENCES people (id)
);

CREATE TABLE polyclinics
(
    code     VARCHAR(16) PRIMARY KEY NOT NULL,
    name     VARCHAR(100)            NOT NULL,
    location VARCHAR(50)             NOT NULL,
    note     TEXT
);

CREATE TABLE specialists
(
    code VARCHAR(16) PRIMARY KEY NOT NULL,
    name VARCHAR(255)            NOT NULL,
    note TEXT
);

CREATE TABLE doctors_polyclinics
(
    doctor_code     VARCHAR(16) NOT NULL,
    polyclinic_code VARCHAR(16) NOT NULL,
    UNIQUE (doctor_code, polyclinic_code),
    CONSTRAINT fk_doctors_polyclinics_doctors FOREIGN KEY (doctor_code) REFERENCES doctors (code),
    CONSTRAINT fk_doctors_polyclinics_polyclinics FOREIGN KEY (polyclinic_code) REFERENCES polyclinics (code)
);

CREATE TABLE doctors_specialists
(
    doctor_code     VARCHAR(16) NOT NULL,
    specialist_code VARCHAR(16) NOT NULL,
    UNIQUE (doctor_code, specialist_code),
    CONSTRAINT fk_doctors_specialists_doctors FOREIGN KEY (doctor_code) REFERENCES doctors (code),
    CONSTRAINT fk_doctors_specialists_specialists FOREIGN KEY (specialist_code) REFERENCES specialists (code)
);

CREATE TABLE ethnicities
(
    id   SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    type ENUM ('Ethnic', 'Nationality')               NOT NULL,
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
    name             VARCHAR(100)            NOT NULL,
    telephone_number VARCHAR(15)             NOT NULL
);

CREATE TABLE custodians
(
    id        BIGINT UNSIGNED                                                            NOT NULL PRIMARY KEY,
    people_id BIGINT UNSIGNED                                                            NOT NULL,
    relation  ENUM ('Father', 'Mother','Wife','Husband','Sibling','Child','Self','Misc') NOT NULL,
    job       VARCHAR(50)                                                                NOT NULL,
    CONSTRAINT fk_custodians_people FOREIGN KEY (people_id) REFERENCES people (id)
);

CREATE TABLE patients
(
    medical_record_code BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    people_id           BIGINT UNSIGNED                            NOT NULL,
    ethnic_id           SMALLINT UNSIGNED                          NOT NULL,
    language_id         SMALLINT UNSIGNED                          NOT NULL,
    custodian_id        BIGINT UNSIGNED                            NOT NULL,
    last_education      ENUM ('Elementary School', 'Junior High School', 'Senior/Vocational High School', 'Diploma 3', 'Bachelor Degree', 'Associate Degree', 'Master Degree'),
    mother_name         VARCHAR(50)                                NOT NULL,
    registration_date   DATE                                       NOT NULL,
    job                 VARCHAR(50)                                NOT NULL,
    employee_code       VARCHAR(50),
    CONSTRAINT fk_patients_people FOREIGN KEY (people_id) REFERENCES people (id),
    CONSTRAINT fk_patients_custodians FOREIGN KEY (custodian_id) REFERENCES custodians (id)
);

CREATE TABLE patients_disabilities
(
    medical_record_code BIGINT UNSIGNED NOT NULL,
    disabilities_id     SMALLINT UNSIGNED,
    UNIQUE (medical_record_code, disabilities_id),
    CONSTRAINT fk_patients_disabilities_patients FOREIGN KEY (medical_record_code) REFERENCES patients (medical_record_code),
    CONSTRAINT fk_patients_disabilities_disabilities FOREIGN KEY (disabilities_id) REFERENCES disabilities (id)
);

CREATE TABLE patients_insurances
(
    medical_record_code BIGINT UNSIGNED NOT NULL,
    insurances_code     VARCHAR(16)     NOT NULL,
    UNIQUE (medical_record_code, insurances_code),
    CONSTRAINT fk_patients_insurances_patients FOREIGN KEY (medical_record_code) REFERENCES patients (medical_record_code),
    CONSTRAINT fk_patients_insurances_insurances FOREIGN KEY (insurances_code) REFERENCES insurances (code)
);

CREATE TABLE patients_instances
(
    medical_record_code BIGINT UNSIGNED NOT NULL,
    instances_code      VARCHAR(16)     NOT NULL,
    CONSTRAINT fk_patients_instances_patients FOREIGN KEY (medical_record_code) REFERENCES patients (medical_record_code),
    CONSTRAINT fk_patients_instances_instances FOREIGN KEY (instances_code) REFERENCES insurances (code)

)