CREATE TABLE IF NOT EXISTS marques
(
    id_marque int not null AUTO_INCREMENT primary key,
    name varchar(50)
);

-- Marques  1 - n Voitures
-- Clients  1 - n Voitures

CREATE TABLE IF NOT EXISTS voitures
(
    id_voiture int not null AUTO_INCREMENT primary key,
    name varchar(50),
    id_marque int NOT NULL REFERENCES marques(id_marque),
    id_client int NOT NULL REFERENCES clients(id_client)
);


CREATE TABLE IF NOT EXISTS concessionnaires
(
    id_concessionnaire int not null AUTO_INCREMENT primary key,
    name varchar(50)
);

CREATE TABLE IF NOT EXISTS clients
(
    id_client int not null AUTO_INCREMENT primary key,
    name varchar(50)
);

-- Concessionnaire 1 - n Adresse

CREATE TABLE IF NOT EXISTS adresses
(
    id_adresse int not null AUTO_INCREMENT primary key,
    adresse_ville varchar(80),
    pays varchar(50),
    telephone varchar(15),
    id_concessionnaire int NOT NULL REFERENCES concessionnaires(id_concessionnaire)
);

-- Concessionnaire n - n Marques

CREATE TABLE IF NOT EXISTS concessionnaires_marques_junction
(
    id_concessionnaire int,
    id_marque int,
    CONSTRAINT concessionnaire_marque_pk PRIMARY KEY (id_concessionnaire, id_marque),
    CONSTRAINT FK_concessionnaire FOREIGN KEY (id_concessionnaire) REFERENCES concessionnaires (id_concessionnaire),
    CONSTRAINT FK_marque FOREIGN KEY (id_marque) REFERENCES marques (id_marque)
);


INSERT INTO concessionnaires (id_concessionnaire, name) VALUES
(1, '4S AUTOMOBILES'),(2, 'CAR MOTORS'),(3, 'Renault Annappes Automobiles'),
(4, 'Lexus Toys Plus Lille'),(5, 'Auto République');

--INSERT INTO adresses (id_adresse, adresse_ville, pays, id_concessionnaire) VALUES
--(1, 'La ManufactureLille','France' , 1),
--(2, '119 Rue Jeanne d Arc', 'France', 2),
--(3, '99 Rue Marcel Bouderiez', 'France', 3),
--(4, '2 Rue du Frenelet', 'France', 4),

INSERT INTO adresses VALUES(1, 'La ManufactureLille', 'France', '07 67 02 71 51', 1);
INSERT INTO adresses VALUES(2, '119 Rue Jeanne d Arc', 'France', '03 20 42 04 78', 2);
INSERT INTO adresses VALUES(3, '99 Rue Marcel Bouderiez', 'France', '03 20 91 12 09', 3);
INSERT INTO adresses VALUES(4, '2 Rue du Frenelet', 'France', '03 20 34 45 60', 4);
INSERT INTO adresses VALUES(5, '8 Rue du Frenelet', 'France', '06 68 99 21 33', 5);

INSERT INTO clients (id_client, name) VALUES
(1, 'Herman'),(2, 'Daniel'),(3, 'Jordan'),(4, 'Roland'),(5, 'Marc'),(6, 'Vanel'),
(7, 'Rosy'),(8, 'Khelia'),(9, 'Armand'),(10, 'Omer');

INSERT INTO marques (id_marque, name) VALUES
(1, '4S'),(2, 'Lexus'),(3, 'Renault'),(4, 'Toyota'),(5, 'Mercedes');

INSERT INTO concessionnaires_marques_junction (id_concessionnaire, id_marque) VALUES
(1, 1),(2, 2),(3, 3),(4, 4),(5, 5);

INSERT INTO voitures VALUES(1, 'AUTOMOBILES', 1, 1);
INSERT INTO voitures VALUES(2, 'Mercedes Cla', 5, 2);
INSERT INTO voitures VALUES(3, 'Berlines', 3, 3);
INSERT INTO voitures VALUES(4, 'Lexus Toys Plus', 2, 4);
INSERT INTO voitures VALUES(5, 'Citadines', 3, 5);
INSERT INTO voitures VALUES(6, 'TOYOTA YARIS', 4, 1);
INSERT INTO voitures VALUES(7, 'TOYOTA Auris', 4, 1);
INSERT INTO voitures VALUES(8, 'Toyota Aygo', 4, 5);
INSERT INTO voitures VALUES(9, 'Mercedes-Benz', 5, 4);
INSERT INTO voitures VALUES(10, 'Mercedes-Ci', 7, 2);


