USE world;
CREATE TABLE Clienti (
    id INT,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    email VARCHAR(100),
    eta INT,
    citta VARCHAR(100)
);

INSERT INTO Clienti (id, nome, cognome, email, eta, citta) VALUES
(1, 'Alessandro', 'Rossi', 'alessandro.rossi@gmail.com', 32, 'Roma'),
(2, 'Anna', 'Bianchi', 'anna.bianchi@yahoo.com', 27, 'Milano'),
(3, 'Marco', 'Verdi', 'marco.verdi@gmail.com', 38, 'Palermo'),
(4, 'Andrea', 'Neri', 'andrea.neri@gmail.com', 29, 'Firenze'),
(5, 'Luca', 'Matti', 'luca.matti@hotmail.com', 41, 'Napoli'),
(6, 'Alessia', 'Sassi', 'alessia.sassi@gmail.com', 34, 'Torino'),
(7, 'Marta', 'Piano', 'marta.piano@gmail.com', 36, 'Genova'),
(8, 'Francesco', 'Lopez', 'francesco.lopez@outlook.com', 31, 'Bologna'),
(9, 'Giulia', 'Serra', 'giulia.serra@gmail.com', 40, 'Roma'),
(10, 'Antonio', 'Manca', 'antonio.manca@gmail.com', 28, 'Roma'),
(11, 'Alberto', 'Piras', 'alberto.piras@gmail.com', 33, 'Cagliari'),
(12, 'Elena', 'Manni', 'elena.manni@gmail.com', 25, 'Roma'),
(13, 'Riccardo', 'Valli', 'riccardo.valli@libero.it', 37, 'Perugia'),
(14, 'Angela', 'Prati', 'angela.prati@gmail.com', 39, 'Roma'),
(15, 'Roberto', 'Petri', 'roberto.petri@gmail.com', 30, 'Livorno'),
(16, 'Giorgia', 'Bosco', 'giorgia.bosco@gmail.com', 24, 'Vicenza'),
(17, 'Federico', 'Ruota', 'federico.ruota@gmail.com', 35, 'Roma Nord'),
(18, 'Alina', 'Corsi', 'alina.corsi@gmail.com', 31, 'Roma Centro'),
(19, 'Aurora', 'Fiore', 'aurora.fiore@gmail.com', 29, 'Roma Sud'),
(20, 'Simone', 'Denti', 'simone.denti@gmail.com', 42, 'Pescara');
SELECT * FROM Clienti;

-- Seleziona tutti i clienti la cui email termina con @gmail.com.
SELECT * FROM world.clienti
WHERE email LIKE '%@gmail.com';

-- Mostra tutti i clienti il cui nome comincia con la lettera A
SELECT * FROM world.clienti
WHERE nome LIKE 'A%';

-- Mostra tutti i clienti il cui 
-- cognome è composto da esattamente 5 caratteri.

SELECT COUNT(*) AS numeroClienti5Caratteri
FROM world.clienti
WHERE cognome LIKE '_____';

-- Elenca i clienti che hanno un'età compresa tra 30 e 40 anni,
-- inclusi gli estremi.
SELECT *
FROM world.clienti
WHERE eta BETWEEN 30 AND 40;

-- Mostra tutti i clienti che abitano in una città 
-- il cui nome contiene la stringa roma, 
-- indipendentemente da maiuscole o minuscole.
SELECT *
FROM world.clienti
WHERE citta LIKE '%roma%' OR citta LIKE '%ROMA%' OR citta LIKE '%Roma%' OR citta LIKE '%RoMa%'     