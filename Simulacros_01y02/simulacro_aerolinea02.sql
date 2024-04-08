USE bqyaj9aadstsfautarvm;

CREATE TABLE avion(
	id INT AUTO_INCREMENT PRIMARY KEY,
    modelo varchar(255) NOT NULL,
    capacidad INT NOT NULL
);

DROP TABLE avion;

CREATE TABLE vuelo(
	id INT AUTO_INCREMENT PRIMARY KEY,
    destino varchar (255) NOT NULL,
    fecha_salida DATE, 
    hora_salida TIME,
    id_avion INT,
    FOREIGN KEY (id_avion) REFERENCES avion(id) ON DELETE CASCADE
);

CREATE TABLE pasajero(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(255) NOT NULL,
    apellido varchar(255) NOT NULL,
    documento_identidad VARCHAR(255) NOT NULL
);

CREATE TABLE reserva(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_reserva DATE,
    asiento varchar(255),
    id_pasajero INT,
    id_vuelo INT,
    FOREIGN KEY (id_pasajero) REFERENCES pasajero(id) ON DELETE CASCADE,
    FOREIGN KEY (id_vuelo) REFERENCES vuelo(id) ON DELETE CASCADE
);