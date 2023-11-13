DROP table IF EXISTS departamentos;
DROP table IF EXISTS empleados;

CREATE TABLE departamentos (
codigo int auto_increment,
nombre nvarchar(100),
presupuesto int,
PRIMARY KEY (codigo)
);

INSERT INTO departamentos (nombre, presupuesto) VALUES ('Departamento A', 10000);
INSERT INTO departamentos (nombre, presupuesto) VALUES ('Departamento B', 15000);

CREATE TABLE empleados (
dni varchar(8),
nombre nvarchar(100),
apellidos nvarchar(255),
codigo_departamento int,
PRIMARY KEY (dni),
FOREIGN KEY (codigo_departamento) REFERENCES Departamentos(codigo)
ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO empleados (dni, nombre, apellidos, codigo_departamento) VALUES ('11111111', 'Juan', 'Perez', 1);
INSERT INTO empleados (dni, nombre, apellidos, codigo_departamento) VALUES ('22222222', 'Maria', 'Lopez', 1);
INSERT INTO empleados (dni, nombre, apellidos, codigo_departamento) VALUES ('33333333', 'Carlos', 'Sanchez', 2);
INSERT INTO empleados (dni, nombre, apellidos, codigo_departamento) VALUES ('44444444', 'Laura', 'Martinez', 2);