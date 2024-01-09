DROP DATABASE IF EXISTS spring_asclepius_api;
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
    person_id            BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT                                  NOT NULL,
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
    person_id              BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    code                   VARCHAR(16) UNIQUE          NOT NULL,
    alumnus                VARCHAR(100)                NOT NULL,
    practice_permit_number VARCHAR(30)                 NOT NULL,
    CONSTRAINT fk_doctors_people FOREIGN KEY (person_id) REFERENCES people (person_id)
);

CREATE TABLE polyclinics
(
    code             VARCHAR(16) PRIMARY KEY NOT NULL,
    name             VARCHAR(100)            NOT NULL,
    registration_fee INT                     NOT NULL,
    location         VARCHAR(50)             NOT NULL,
    note             TEXT
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
    CONSTRAINT fk_doctors_polyclinics_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (person_id),
    CONSTRAINT fk_doctors_polyclinics_polyclinics FOREIGN KEY (polyclinic_code) REFERENCES polyclinics (code)
);

CREATE TABLE doctors_specialities
(
    doctor_id       BIGINT UNSIGNED NOT NULL,
    speciality_code VARCHAR(16)     NOT NULL,
    UNIQUE (doctor_id, speciality_code),
    CONSTRAINT fk_doctors_specialities_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (person_id),
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
    person_id BIGINT UNSIGNED PRIMARY KEY                                                NOT NULL,
    relation  ENUM ('FATHER', 'MOTHER','WIFE','HUSBAND','SIBLING','CHILD','SELF','MISC') NOT NULL,
    job       VARCHAR(50)                                                                NOT NULL,
    CONSTRAINT fk_custodians_people FOREIGN KEY (person_id) REFERENCES people (person_id)
);

CREATE TABLE patients
(
    person_id           BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    medical_record_code VARCHAR(128) UNIQUE         NOT NULL,
    ethnic_id           SMALLINT UNSIGNED           NOT NULL,
    custodian_id        BIGINT UNSIGNED             NOT NULL,
    instance_code       VARCHAR(16),
    mother_name         VARCHAR(50)                 NOT NULL,
    registration_date   DATE                        NOT NULL,
    job                 VARCHAR(50)                 NOT NULL,
    employee_code       VARCHAR(50),
    CONSTRAINT fk_patients_people FOREIGN KEY (person_id) REFERENCES people (person_id),
    CONSTRAINT fk_patients_custodians FOREIGN KEY (custodian_id) REFERENCES custodians (person_id),
    CONSTRAINT fk_patients_instances FOREIGN KEY (instance_code) REFERENCES instances (code),
    CONSTRAINT fk_patients_ethnicities FOREIGN KEY (ethnic_id) REFERENCES ethnicities (id)
);


CREATE TABLE patients_disabilities
(
    patient_id    BIGINT UNSIGNED   NOT NULL,
    disability_id SMALLINT UNSIGNED NOT NULL,
    UNIQUE (patient_id, disability_id),
    CONSTRAINT fk_patients_disabilities_patients FOREIGN KEY (patient_id) REFERENCES patients (person_id),
    CONSTRAINT fk_patients_disabilities_disabilities FOREIGN KEY (disability_id) REFERENCES disabilities (id)
);

CREATE TABLE patients_insurances
(
    patient_id     BIGINT UNSIGNED NOT NULL,
    insurance_code VARCHAR(16)     NOT NULL,
    UNIQUE (patient_id, insurance_code),
    CONSTRAINT fk_patients_insurances_patients FOREIGN KEY (patient_id) REFERENCES patients (person_id),
    CONSTRAINT fk_patients_insurances_insurances FOREIGN KEY (insurance_code) REFERENCES insurances (code)
);

CREATE TABLE patients_languages
(
    patient_id  BIGINT UNSIGNED   NOT NULL,
    language_id SMALLINT UNSIGNED NOT NULL,
    UNIQUE (patient_id, language_id),
    CONSTRAINT fk_patients_languages_patients FOREIGN KEY (patient_id) REFERENCES patients (person_id),
    CONSTRAINT fk_patients_languages_languages FOREIGN KEY (language_id) REFERENCES languages (id)
);

CREATE TABLE outpatients
(
    registration_code VARCHAR(18) PRIMARY KEY NOT NULL,
    registration_date DATETIME                NOT NULL,
    doctor_id         BIGINT UNSIGNED         NOT NULL,
    patient_id        BIGINT UNSIGNED         NOT NULL,
    polyclinic_code   VARCHAR(16)             NOT NULL,
    insurance_code    VARCHAR(16)             NOT NULL,
    CONSTRAINT fk_outpatients_doctors FOREIGN KEY (doctor_id) REFERENCES doctors (person_id),
    CONSTRAINT fk_outpatients_patients FOREIGN KEY (patient_id) REFERENCES patients (person_id),
    CONSTRAINT fk_outpatients_polyclinics FOREIGN KEY (polyclinic_code) REFERENCES polyclinics (code),
    CONSTRAINT fk_outpatients_insurances FOREIGN KEY (insurance_code) REFERENCES insurances (code)
);

CREATE TABLE positions
(
    code VARCHAR(16) PRIMARY KEY NOT NULL,
    name VARCHAR(255)            NOT NULL
);

CREATE TABLE employees
(
    person_id     BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    position_code VARCHAR(16)                 NOT NULL,
    CONSTRAINT fk_employees_people FOREIGN KEY (person_id) REFERENCES people (person_id),
    CONSTRAINT fk_employees_positions FOREIGN KEY (position_code) REFERENCES positions (code)
);


CREATE TABLE actions_categories
(
    id   INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)                            NOT NULL
);

CREATE TABLE actions
(
    code        VARCHAR(16) PRIMARY KEY NOT NULL,
    name        VARCHAR(255)            NOT NULL,
    category_id INT UNSIGNED            NOT NULL,
    fee         INT UNSIGNED            NOT NULL,
    CONSTRAINT fk_actions_categories FOREIGN KEY (category_id) REFERENCES actions_categories (id)
);

CREATE TABLE examinations
(
    id                 BIGINT UNSIGNED PRIMARY KEY                           NOT NULL,
    registration_code  VARCHAR(18)                                           NOT NULL,
    subject            VARCHAR(255)                                          NOT NULL,
    object             VARCHAR(255)                                          NOT NULL,
    temperature        TINYINT UNSIGNED                                      NOT NULL,
    tension_diastolic  TINYINT UNSIGNED                                      NOT NULL,
    tension_systolic   TINYINT UNSIGNED                                      NOT NULL,
    weight             SMALLINT UNSIGNED                                     NOT NULL,
    height             SMALLINT UNSIGNED                                     NOT NULL,
    respiration_rate   SMALLINT UNSIGNED                                     NOT NULL,
    pulse              SMALLINT UNSIGNED                                     NOT NULL,
    oxygen_saturation  SMALLINT UNSIGNED                                     NOT NULL,
    glasgow_coma_scale TINYINT UNSIGNED                                      NOT NULL,
    consciousness      ENUM ('COMPOS_MENTIS', 'SOMNOLENCE', 'SOPOR', 'COMA') NOT NULL,
    allergy            VARCHAR(255),
    assessment         TEXT                                                  NOT NULL,
    plan               TEXT                                                  NOT NULL,
    instruction        TEXT                                                  NOT NULL,
    evaluation         TEXT                                                  NOT NULL,
    note               TEXT,
    CONSTRAINT fk_examinations_outpatients FOREIGN KEY (registration_code) REFERENCES outpatients (registration_code)
);

CREATE TABLE examinations_obstetrics
(
    examination_id        BIGINT UNSIGNED PRIMARY KEY                NOT NULL,
    uterine_fundus_height TINYINT UNSIGNED                           NOT NULL,
    fetus                 ENUM ('NOT_EXIST', 'SINGLETON', 'GEMELLI') NOT NULL,
    location              VARCHAR(255)                               NOT NULL,
    contraction           ENUM ('POSITIVE', 'NEGATIVE')              NOT NULL,
    quality               SMALLINT UNSIGNED                          NOT NULL,
    vulva                 VARCHAR(255)                               NOT NULL,
    portio_inspeculo      VARCHAR(255)                               NOT NULL,
    pelvis_lower_part     TINYINT                                    NOT NULL,
    cervical_opening      TEXT                                       NOT NULL,
    cervical_descent      TEXT                                       NOT NULL,
    fluxus                ENUM ('POSITIVE', 'NEGATIVE')              NOT NULL,
    fluor_albus           ENUM ('POSITIVE', 'NEGATIVE')              NOT NULL,
    amniotic_membrane     ENUM ('POSITIVE', 'NEGATIVE')              NOT NULL,
    vulva_condition       ENUM ('SPRINGY', 'LENIENT')                NOT NULL,
    denominator           VARCHAR(255)                               NOT NULL,
    direction             ENUM ('FRONT', 'AXIAL', 'BACK')            NOT NULL,
    feto_pelvic_balance   ENUM ('NORMAL', 'SUSP_CPF_FPD', 'CPD_FPD') NOT NULL,
    CONSTRAINT fk_examinations_obstetrics FOREIGN KEY (examination_id) REFERENCES examinations (id)
);

CREATE TABLE examinations_gynecologicals
(
    examination_id            BIGINT UNSIGNED PRIMARY KEY   NOT NULL,
    inspection                VARCHAR(255)                  NOT NULL,
    vulva                     VARCHAR(255)                  NOT NULL,
    inspeculo                 VARCHAR(255)                  NOT NULL,
    fluxus                    ENUM ('POSITIVE', 'NEGATIVE') NOT NULL,
    fluor_albus               ENUM ('POSITIVE', 'NEGATIVE') NOT NULL,
    portio_inspeculo          VARCHAR(255)                  NOT NULL,
    sondage_inspeculo         VARCHAR(255)                  NOT NULL,
    internal_portio_inspeculo VARCHAR(255)                  NOT NULL,
    shape                     VARCHAR(255)                  NOT NULL,
    uterine_cavity            VARCHAR(255)                  NOT NULL,
    mobility                  ENUM ('POSITIVE', 'NEGATIVE') NOT NULL,
    size                      VARCHAR(255)                  NOT NULL,
    tenderness                ENUM ('POSITIVE', 'NEGATIVE'),
    right_adnexa              VARCHAR(255)                  NOT NULL,
    left_adnexa               VARCHAR(255)                  NOT NULL,
    douglas_cavity            VARCHAR(255)                  NOT NULL,
    CONSTRAINT fk_examinations_gynecologicals FOREIGN KEY (examination_id) REFERENCES examinations (id)
);

CREATE TABLE diseases_categories
(
    id   INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) UNIQUE                     NOT NULL
);

CREATE TABLE diseases
(
    code              VARCHAR(10) PRIMARY KEY               NOT NULL,
    name              VARCHAR(255)                          NOT NULL,
    description       TEXT                                  NOT NULL,
    category_id       INT UNSIGNED                          NOT NULL,
    complication      TEXT                                  NOT NULL,
    indication        TEXT,
    risk_prognosis    ENUM ('LOW', 'MODERATE', 'HIGH')      NOT NULL,
    contagious_status ENUM ('CONTAGIOUS', 'NOT_CONTAGIOUS') NOT NULL,
    symptom           TEXT                                  NOT NULL,
    CONSTRAINT fk_diseases_categories FOREIGN KEY (category_id) REFERENCES diseases_categories (id)
);

CREATE TABLE procedures
(
    code                VARCHAR(16) PRIMARY KEY NOT NULL,
    name                VARCHAR(255)            NOT NULL,
    description         TEXT                    NOT NULL,
    patient_preparation TEXT                    NOT NULL,
    procedure_action    TEXT                    NOT NULL,
    patient_recovery    TEXT                    NOT NULL,
    duration            TIME                    NOT NULL
);

CREATE TABLE diseases_procedures
(
    disease_code   VARCHAR(10) NOT NULL,
    procedure_code VARCHAR(16) NOT NULL,
    UNIQUE (disease_code, procedure_code),
    CONSTRAINT fk_diseases_procedures_diseases FOREIGN KEY (disease_code) REFERENCES diseases (code),
    CONSTRAINT fk_diseases_procedures_procedures FOREIGN KEY (procedure_code) REFERENCES procedures (code)
);

CREATE TABLE medicines_dosage_forms
(
    id          INT UNSIGNED PRIMARY KEY NOT NULL,
    name        VARCHAR(255) UNIQUE      NOT NULL,
    description TEXT                     NOT NULL
);

CREATE TABLE medicines_pharmacological_categories
(
    id          INT UNSIGNED PRIMARY KEY NOT NULL,
    name        VARCHAR(255)             NOT NULL,
    description TEXT                     NOT NULL
);

CREATE TABLE pharmaceuticals_industries
(
    id          INT UNSIGNED PRIMARY KEY NOT NULL,
    name        VARCHAR(255)             NOT NULL,
    description TEXT                     NOT NULL
);

CREATE TABLE medicines
(
    code                        VARCHAR(16) PRIMARY KEY NOT NULL,
    dosage_form_id              INT UNSIGNED            NOT NULL,
    pharmacological_category_id INT UNSIGNED            NOT NULL,
    pharmaceutical_industry_id  INT UNSIGNED            NOT NULL,
    name                        VARCHAR(255)            NOT NULL,
    unit                        VARCHAR(50)             NOT NULL,
    price                       INT UNSIGNED            NOT NULL,
    batch                       VARCHAR(50)             NOT NULL,
    expired_date                DATE                    NOT NULL,
    stock                       INT UNSIGNED            NOT NULL,
    CONSTRAINT fk_medicines_pharmaceuticals_industries FOREIGN KEY (pharmaceutical_industry_id) REFERENCES pharmaceuticals_industries (id),
    CONSTRAINT fk_medicines_dosages_forms FOREIGN KEY (dosage_form_id) REFERENCES medicines_dosage_forms (id),
    CONSTRAINT fk_medicines_pharmacological_categories FOREIGN KEY (pharmacological_category_id) REFERENCES medicines_pharmacological_categories (id)
);

CREATE TABLE outpatients_medicines
(
    medicine_code     VARCHAR(16) NOT NULL,
    registration_code VARCHAR(18) NOT NULL,
    quantity          SMALLINT    NOT NULL,
    UNIQUE (medicine_code, registration_code),
    CONSTRAINT fk_outpatients_medicines_medicines FOREIGN KEY (medicine_code) REFERENCES medicines (code),
    CONSTRAINT fk_outpatients_medicines_outpatients FOREIGN KEY (registration_code) REFERENCES outpatients (registration_code)
);