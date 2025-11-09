-- schema.sql
CREATE TABLE IF NOT EXISTS prescription (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    prescription_date DATE,
    patient_name VARCHAR(255),
    patient_age INT,
    patient_gender VARCHAR(10),
    diagnosis VARCHAR(500),
    medicines VARCHAR(500),
    next_visit_date DATE
);
