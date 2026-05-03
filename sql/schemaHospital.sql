CREATE DATABASE dbHospital;
USE dbHospital;

CREATE TABLE patient(
    id INTEGER NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    birth_date DATETIME,
    status BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE speciality(
    id INTEGER NOT NULL AUTO_INCREMENT,
    description VARCHAR(40),
    PRIMARY KEY (id)
);

CREATE TABLE doctor(
    id INTEGER NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    id_speciality INTEGER,
    status BOOLEAN,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_speciality FOREIGN KEY (id_speciality) REFERENCES speciality(id)
);

CREATE TABLE timetable(
    _day DATE,
    hour_start TIME,
    hour_end TIME,
    PRIMARY KEY (_day, hour_start, hour_end)
);

CREATE TABLE timetableXdoctor(
    id_doctor_TXD INTEGER,
    day_TXD DATE,
    hour_start_TXD TIME,
    hour_end_TXD TIME,
    PRIMARY KEY (id_doctor_TXD, day_TXD, hour_start_TXD, hour_end_TXD),
    CONSTRAINT fk_id_doctor_TXD FOREIGN KEY (id_doctor_TXD) REFERENCES doctor(id),
    CONSTRAINT fk_timetable_TXD FOREIGN KEY (day_TXD, hour_start_TXD, hour_end_TXD) REFERENCES timetable(_day, hour_start, hour_end)
);

CREATE TABLE turn(
    id INTEGER NOT NULL AUTO_INCREMENT,
    id_patient_T INTEGER,
    id_doctor_T INTEGER,
    day_T DATE,
    hour_start_T TIME,
    hour_end_T TIME,
    description VARCHAR(50),
    status BOOLEAN,
    PRIMARY KEY (id),
    UNIQUE (id_patient_T, id_doctor_T, day_T, hour_start_T, hour_end_T),
    CONSTRAINT fk_id_patient_T FOREIGN KEY (id_patient_T) REFERENCES patient(id),
    CONSTRAINT fk_id_doctor_T FOREIGN KEY (id_doctor_T) REFERENCES doctor(id),
    CONSTRAINT fk_timetable_T FOREIGN KEY (day_T, hour_start_T, hour_end_T) REFERENCES timetable(_day, hour_start, hour_end)
);