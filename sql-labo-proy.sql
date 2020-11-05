CREATE DATABASE TiendaArticulos

USE TiendaArticulos

CREATE TABLE tipoArticulo
(
idTA INT IDENTITY (1,1) NOT NULL,
denominacionTA VARCHAR (100),
CONSTRAINT PK_tipoArticulo PRIMARY KEY (idTA)
)

CREATE TABLE pareja
(
idP INT IDENTITY (1,1) NOT NULL,
nombre1 VARCHAR (50),
apellido1 VARCHAR (50),
nombre2 VARCHAR (50),
apellido2 VARCHAR (50),
idBorrado INT,
CONSTRAINT PK_pareja PRIMARY KEY (idP),
)

CREATE TABLE articulo
(
idA INT IDENTITY (1,1) NOT NULL,
codigo VARCHAR (10),
denominacionA VARCHAR (100),
precioUnitario REAL,
idTA INT,
idBorrado INT,
CONSTRAINT PK_articulo PRIMARY KEY (idA),
CONSTRAINT fk_ta FOREIGN KEY (idTA) REFERENCES tipoArticulo(idTA)
)

CREATE TABLE articuloPareja
(
idAP INT IDENTITY (1,1) NOT NULL,
idA INT,
idPa INT,
CONSTRAINT PK_articulo_pareja PRIMARY KEY (idAP),
CONSTRAINT FK_articulo_ FOREIGN KEY (idA) REFERENCES articulo(idA),
CONSTRAINT FK_Articulo_Pareja FOREIGN KEY (idPa) REFERENCES pareja (idP)
)

CREATE TABLE invitado
(
idI INT IDENTITY (1,1) NOT NULL,
nombreI VARCHAR (50),
CONSTRAINT PK_invitado PRIMARY KEY (idI),
)

CREATE TABLE deposito
(
idD INT IDENTITY (1,1) NOT NULL,
montoD real,
idP INT,
idI INT NULL, 
CONSTRAINT PK_regalo PRIMARY KEY (idD),
CONSTRAINT FK_regalo_pareja FOREIGN KEY (idP) REFERENCES pareja (idP),
CONSTRAINT FK_regalo_invitado FOREIGN KEY (idI) REFERENCES invitado (idI),
)

CREATE TABLE compras
(
idCompra INT IDENTITY (1,1) NOT NULL,
dineroDisponible real, 
idP INT,
CONSTRAINT PK_compras PRIMARY KEY (idCompra),
CONSTRAINT FK_compra_pareja FOREIGN KEY (idP) REFERENCES pareja (idP)
)

INSERT INTO tipoArticulo
VALUES ('Electrodomésticos'),('Muebles'),('Jardín')

INSERT INTO pareja
VALUES ('Pedro', 'Gomez', 'Julieta', 'Perez', 0),
	   ('Federico', 'Chavez', 'Ludmila', 'Suarez', 0),
	   ('Marcos', 'Gonzalez', 'Catalina', 'Diaz', 0),
	   ('Franco', 'Balsamo', 'Natalia', 'Gonzalez', 0),
	   ('Mario', 'Osmerini', 'Luciana', 'Conci', 0),
	   ('Leandro', 'Giannobi', 'Aylen', 'Casermeiro', 0)
SELECT * FROM pareja
SELECT idP, nombre1 + ' '  + apellido1 AS nombreCompletoUno, nombre2 + ' '  + apellido2 AS nombreCompletoDos FROM pareja WHERE idBorrado = 0

INSERT INTO articulo
VALUES ('101-A', 'Heladera', 70000, 1, 0), ('101-B', 'Televisor', 50000, 1, 0), ('101-C', 'Lavarropas', 40000, 1, 0), 
	   ('201-A', 'Cama', 35000, 2, 0), ('201-B', 'Velador', 15000, 2, 0), ('201-C', 'Escritorio', 20000, 2, 0),
	   ('301-A', 'Podadora', 85000, 3, 0), ('301-B', 'Pasto artificial', 5000, 3, 0), ('301-C', 'Macetas', 2000, 3, 0)

SELECT * FROM articulo

INSERT INTO articuloPareja
VALUES (1,1),(4,1),(7,1),
	   (2,2),(5,2),(8,2),
	   (3,3),(6,3),(9,3),
	   (1,4),(4,4),(7,4),
	   (2,5),(5,5),(8,5),
	   (1,6),(4,1),(9,1),
	   (7,4),(1,5),(4,6),
	   (6,4),(5,5),(9,6),
	   (2,4),(3,5),(8,6),
	   (5,4),(4,5),(1,6),
	   (7,4),(1,5),(4,6),
	   (6,4),(5,5),(9,6),
	   (2,4),(3,5),(8,6),
	   (5,4),(4,5),(1,6),
	   (3,5),(3,5),(3,5),
	   (3,1),(3,2),(3,3),
	   (6,1),(6,2),(6,3), 
	   (9,1),(9,2),(9,3)

SELECT * from articuloPareja

---------------------------------------------------------------------------
-------------------------------------CONSULTAS-----------------------------
---------------------------------------------------------------------------

--REPORTES
/*1*/
/*2*/SELECT SUM(a.precioUnitario) FROM articuloPareja ap INNER JOIN articulo a ON ap.idA = a.idA INNER JOIN pareja p ON p.idP = ap.idPa
/*3*/SELECT TOP 5 a.denominacionA, COUNT(ap.idPa) FROM articuloPareja ap INNER JOIN pareja p ON ap.idPa = p.idP INNER JOIN articulo a ON a.idA = ap.idA GROUP BY a.denominacionA HAVING COUNT(ap.idPa) >=5

--Consultas
SELECT idP, nombre1, apellido1, nombre2, apellido2 FROM pareja WHERE idP = 1
SELECT idA, codigo, denominacionA, precioUnitario FROM articulo WHERE idA = 1
SELECT p.nombre1 + ' ' + p.apellido1, p.nombre2 + ' ' + p.apellido2, a.denominacionA, a.precioUnitario FROM articuloPareja ap INNER JOIN articulo a ON ap.idA = a.idA INNER JOIN pareja p ON ap.idPa = p.idP WHERE ap.idPa = 1
SELECT idA, codigo, denominacionA, a.idTA, ta.denominacionTA, precioUnitario FROM articulo a INNER JOIN tipoArticulo ta ON a.idTA = ta.idTA WHERE idA = 1
