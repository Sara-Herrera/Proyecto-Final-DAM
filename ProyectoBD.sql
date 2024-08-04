USE proyecto;

CREATE TABLE `proyecto`.`usuario` (
    `id_usuario` INT AUTO_INCREMENT, 
    `dni` VARCHAR(9) NOT NULL,
    `nombre` VARCHAR(15) NOT NULL,
    `apellidos` VARCHAR(30) NOT NULL,
    `departamento` VARCHAR(30),
    `puesto` VARCHAR(30),
    `email` VARCHAR(40) NOT NULL,
    `contrasena` VARCHAR(10) NOT NULL,
    `rol` VARCHAR(5) NOT NULL,
    PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `proyecto`.`Frutal` (
  `ID` INT AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Especie` VARCHAR(20) NOT NULL,
  `Floracion` VARCHAR(20),
  PRIMARY KEY (`ID`),
  INDEX (`Nombre`)
);

CREATE TABLE `proyecto`.`Albaricoquero` (
  `ID` INT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Color` VARCHAR(20),
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID`) REFERENCES `proyecto`.`Frutal`(`ID`),
  FOREIGN KEY (`Nombre`) REFERENCES `proyecto`.`Frutal`(`Nombre`)
);

CREATE TABLE `proyecto`.`Almendro` (
  `ID` INT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Forma` VARCHAR(20),
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`ID`) REFERENCES `proyecto`.`Frutal`(`ID`),
  FOREIGN KEY (`Nombre`) REFERENCES `proyecto`.`Frutal`(`Nombre`)
);

CREATE TABLE `proyecto`.`ZonaGeografica` (
  `ID` INT AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `proyecto`.`Frutal_Zona` (
  `FrutalID` INT,
  `ZonaID` INT,
  PRIMARY KEY (`FrutalID`, `ZonaID`),
  FOREIGN KEY (`FrutalID`) REFERENCES `proyecto`.`Frutal`(`ID`),
  FOREIGN KEY (`ZonaID`) REFERENCES `proyecto`.`ZonaGeografica`(`ID`)
);


INSERT INTO usuario (id_usuario, dni, nombre, apellidos, departamento, puesto, email, contrasena, rol) VALUES (1, '18721536C', 'Sara', 'Herrera Lagranja', 'Mejora genética', 'Investigador', 'sherrera@gmail.com', 'C0ntraseña', 'admin');
INSERT INTO usuario (id_usuario, dni, nombre, apellidos, departamento, puesto, email, contrasena, rol) VALUES (2, '46997124M', 'Elisa', 'Soto Ortiz', 'Postcosecha', 'Investigador', 'esoto@gmail.com', 'C0ntraseña', 'admin');
INSERT INTO usuario (id_usuario, dni, nombre, apellidos, departamento, puesto, email, contrasena, rol) VALUES (3, '74759620Q', 'Pablo', 'Giner Vila', 'I+D', 'Investigador', 'esoto@gmail.com', 'C0ntraseña', 'admin');

# Frutal
insert into Frutal values (1, "Marta", "Almendro", "Tardia");
insert into Frutal values (2, "Antoneta", "Almendro", "Media");
insert into Frutal values (3, "Belona", "Almendro", "Precoz");
insert into Frutal values (4, "Guara", "Almendro", "Muy precoz");
insert into Frutal values (5, "Lauranne", "Almendro", "Tardia");
insert into Frutal values (6, "Penta", "Almendro", "Extra tardia");
insert into Frutal values (7, "Makako", "Almendro", "Extra tardia");
insert into Frutal values (8, "Soleta", "Almendro", "Tardia");
insert into Frutal values (9, "Moniqui", "Albaricoquero", "Media");
insert into Frutal values (10, "Paviot", "Albaricoquero", "Media");
insert into Frutal values (11, "Mitger", "Albaricoquero", "Precoz");
insert into Frutal values (12, "Tadeo", "Albaricoquero", "Muy precoz");
insert into Frutal values (13, "Rubely", "Albaricoquero", "Tardia");
insert into Frutal values (14, "Farbaly", "Albaricoquero", "Extra tardia");
insert into Frutal values (15, "Medflo", "Albaricoquero", "Precoz");
insert into Frutal values (16, "Pricia", "Albaricoquero", "Precoz");

insert into Almendro values (1, "Marta", "Eliptica");
insert into Almendro values (2, "Antoneta", "Redondeada");
insert into Almendro values (3, "Belona", "Redondeada");
insert into Almendro values (4, "Guara", "Acorazada");
insert into Almendro values (5, "Lauranne", "Alargada");
insert into Almendro values (6, "Penta", "Alargada");
insert into Almendro values (7, "Makako", "Eliptica");
insert into Almendro values (8, "Soleta", "Alargada");

insert into Albaricoquero values (9, "Moniqui", "Rojo");
insert into Albaricoquero values (10, "Paviot", "Bicolor");
insert into Albaricoquero values (11, "Mitger", "Naranja");
insert into Albaricoquero values (12, "Tadeo", "Naranja");
insert into Albaricoquero values (13, "Rubely", "Rojo");
insert into Albaricoquero values (14, "Farbaly", "Bicolor");
insert into Albaricoquero values (15, "Medflo", "Bicolor");
insert into Albaricoquero values (16, "Pricia", "Rojo");


INSERT INTO ZonaGeografica (Nombre) VALUES ("Aragón");
INSERT INTO ZonaGeografica (Nombre) VALUES ("Cataluña");
INSERT INTO ZonaGeografica (Nombre) VALUES ("Comunidad Valenciana");
INSERT INTO ZonaGeografica (Nombre) VALUES ("Murcia");
INSERT INTO ZonaGeografica (Nombre) VALUES ("Castilla-La Mancha");
INSERT INTO ZonaGeografica (Nombre) VALUES ("Andalucía");

-- Relacionar Almendros con zonas geográficas
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (1, 6);  -- Marta en Andalucía
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (2, 2);  -- Antoneta en Cataluña
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (3, 2);  -- Belona en Cataluña
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (4, 1);  -- Guara en Aragón
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (5, 4);  -- Lauranne en Murcia
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (6, 4);  -- Penta en Murcia
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (7, 5);  -- Makako en Castilla-La Mancha
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (8, 6);  -- Soleta en Andalucía

-- Relacionar Albaricoqueros con zonas geográficas
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (9, 1);  -- Moniqui en Aragón
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (10, 1); -- Paviot en Aragón
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (11, 3); -- Mitger en Comunidad Valenciana
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (12, 4); -- Tadeo en Murcia
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (13, 3); -- Rubely en Comunidad Valenciana
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (14, 6); -- Farbaly en Andalucía
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (15, 5); -- Medflo en Castilla-La Mancha
INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (16, 4); -- Pricia en Murcia

