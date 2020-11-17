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

CREATE TABLE IF NOT EXISTS adresses
(
    id_adresse int not null AUTO_INCREMENT primary key,
    adresse_ville varchar(50),
    pays varchar(50),
    numero_de_tel varchar(70),
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


INSERT INTO marques VALUES(1, '4S');
INSERT INTO marques VALUES(2, 'Lexus');
INSERT INTO marques VALUES(3, 'Renault');
INSERT INTO marques VALUES(4, 'Toyota');
INSERT INTO marques VALUES(5, 'Mercedes');

INSERT INTO concessionnaires VALUES(1, '4S AUTOMOBILES');
INSERT INTO concessionnaires VALUES(2, 'CAR MOTORS');
INSERT INTO concessionnaires VALUES(3, 'Renault Annappes Automobiles');
INSERT INTO concessionnaires VALUES(4, 'Lexus Toys Plus Lille');
INSERT INTO concessionnaires VALUES(5, 'Auto République');

INSERT INTO clients VALUES(1, 'Herman');
INSERT INTO clients VALUES(2, 'Daniel');
INSERT INTO clients VALUES(3, 'Jordan');
INSERT INTO clients VALUES(4, 'Roland');
INSERT INTO clients VALUES(5, 'Marc');
INSERT INTO clients VALUES(6, 'Vanel');
INSERT INTO clients VALUES(7, 'Rosy');
INSERT INTO clients VALUES(8, 'Khelia');
INSERT INTO clients VALUES(9, 'Armand');
INSERT INTO clients VALUES(10, 'Omer');

INSERT INTO voitures VALUES(1, 'AUTOMOBILES', 1, 1);
INSERT INTO voitures VALUES(2, 'Mercedes Cla', 5, 2);
INSERT INTO voitures VALUES(3, 'Berlines', 3, 3);
INSERT INTO voitures VALUES(4, 'Lexus Toys Plus', 2, 4);
INSERT INTO voitures VALUES(5, 'Citadines', 3, 5);
INSERT INTO voitures VALUES(6, 'TOYOTA YARIS', 4, 1);
INSERT INTO voitures VALUES(7, 'TOYOTA Auris', 4, 1);
INSERT INTO voitures VALUES(8, 'Toyota Aygo', 4, 5);
INSERT INTO voitures VALUES(9, 'Mercedes-Benz', 5, 4);
INSERT INTO voitures VALUES(10, 'Mercedes-Ci', 5, 2);

INSERT INTO adresses VALUES(1, 'La ManufactureLille', 'France', '07 67 02 71 51', 1);
INSERT INTO adresses VALUES(2, '119 Rue Jeanne d Arc', 'France', '03 20 42 04 78', 2);
INSERT INTO adresses VALUES(3, '99 Rue Marcel Bouderiez', 'France', '03 20 91 12 09', 3);
INSERT INTO adresses VALUES(4, '2 Rue du Frenelet', 'France', '03 20 34 45 60', 4);
INSERT INTO adresses VALUES(5, '8 Rue du Frenelet', 'France', '06 68 99 21 33', 5);

INSERT INTO concessionnaires_marques_junction VALUES(1, 1);
INSERT INTO concessionnaires_marques_junction VALUES(2, 2);
INSERT INTO concessionnaires_marques_junction VALUES(3, 3);
INSERT INTO concessionnaires_marques_junction VALUES(4, 4);
INSERT INTO concessionnaires_marques_junction VALUES(5, 5);

