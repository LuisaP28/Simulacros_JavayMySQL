USE bxqzuxb6geadlg9ardhj;

CREATE TABLE speciality(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name_speciality VARCHAR (45) NOT NULL,
    description_speciality TEXT
);

DROP TABLE speciality;

CREATE TABLE doctor(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name_doctor VARCHAR(45) NOT NULL,
    lastname VARCHAR(45) NOT NULL,
    id_speciality INT,
    FOREIGN KEY (id_speciality) REFERENCES speciality(id) ON DELETE CASCADE
);

CREATE TABLE patient(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name_patient VARCHAR(45) NOT NULL,
    lastname VARCHAR(45) NOT NULL,
    date_birth DATE NOT NULL,
    identification_document VARCHAR(45) UNIQUE NOT NULL
);

CREATE TABLE appointment(
	id INT AUTO_INCREMENT PRIMARY KEY,
    date_appointment DATE NOT NULL,
     time_appointment TIME NOT NULL,
     reason VARCHAR(45),
    id_patient INT,
    id_doctor INT,
    FOREIGN KEY (id_patient) REFERENCES patient(id) ON DELETE CASCADE,
	FOREIGN KEY (id_doctor) REFERENCES doctor(id) ON DELETE CASCADE
);
