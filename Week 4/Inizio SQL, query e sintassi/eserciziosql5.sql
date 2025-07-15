USE world;

CREATE TABLE Clienti (
    id INT,
    nome VARCHAR(100),
    città VARCHAR(100)
);

CREATE TABLE Ordini (
    id INT,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7,2)
);

INSERT INTO Clienti (id, nome, città) VALUES
(1, 'Luca Verdi', 'Roma'),
(2, 'Anna Neri', 'Milano'),
(3, 'Sara Bianchi', 'Napoli'),
(4, 'Marco Rossi', 'Torino'),
(5, 'Elena Conti', 'Genova');

INSERT INTO Ordini (id, id_cliente, data_ordine, importo) VALUES
(1, 1, '2024-05-10', 120.50),   -- Luca Verdi
(2, 2, '2024-05-11', 80.00),    -- Anna Neri
(3, 1, '2024-05-15', 50.00),    -- Luca Verdi (secondo ordine)
(4, 4, '2024-06-01', 220.75),   -- Marco Rossi
(5, NULL, '2024-06-03', 60.00); -- Ordine senza cliente (caso anomalo)

SELECT * FROM world.Clienti;
SELECT * FROM world.Ordini;

-- Esercizio 1 – INNER JOIN  Obiettivo:
-- Visualizza l’elenco dei clienti che hanno effettuato almeno un ordine.
-- Per ciascuno, mostra: nome del cliente, data dell’ordine e importo.
SELECT c.nome AS NomeCliente, o.data_ordine, o.importo
FROM world.clienti c
INNER JOIN world.ordini o ON c.id = o.id_cliente;

-- Esercizio 2 – LEFT JOIN   Obiettivo:
-- Visualizza tutti i clienti, inclusi quelli che non hanno mai effettuato ordini.
-- Mostra per ciascuno: nome del cliente, data dell’ordine (se presente) e importo (se presente).
SELECT c.nome AS NomeCliente, o.data_ordine, o.importo
FROM world.clienti c
LEFT JOIN world.ordini o ON c.id = o.id_cliente;

-- Esercizio 3 – RIGHT JOIN   Obiettivo:
-- Visualizza tutti gli ordini, anche quelli che non hanno un cliente associato (caso anomalo).
-- Mostra per ciascuno: nome del cliente (se esiste), data dell’ordine e importo.
SELECT c.nome AS NomeCliente, o.data_ordine, o.importo
FROM world.clienti c
RIGHT JOIN world.ordini o ON c.id = o.id_cliente;
--
-- Elenca i clienti attivi, cioè quelli che hanno effettuato almeno un ordine, mostrando per ciascuno:
-- Nome del cliente
-- Totale ordini effettuati
-- Somma totale degli importi spesi
-- Elenca i clienti inattivi, cioè quelli che non hanno mai effettuato ordini, mostrando solo:
-- Nome del cliente
-- Città di residenza
-- Individua gli ordini orfani, cioè ordini presenti in tabella ma senza un cliente valido associato (es. cliente cancellato), e mostra:
-- ID dell’ordine
-- Data dell’ordine
-- Importo
-- (Cliente = NULL)
-- Requisiti tecnici:
-- Per il punto 1: usa INNER JOIN.
-- Per il punto 2: usa LEFT JOIN con condizione su IS NULL.
-- Per il punto 3: usa RIGHT JOIN con condizione su IS NULL.

SELECT c.nome AS NomeCliente, COUNT(o.id) AS TotaleOrdini, SUM(o.importo) AS SommaImporti
FROM world.clienti c
INNER JOIN world.ordini o ON c.id = o.id_cliente
GROUP BY c.id, c.nome;

SELECT c.nome AS NomeCliente,c.città AS CittaResidenza
FROM world.clienti c
LEFT JOIN world.ordini o ON c.id = o.id_cliente
WHERE o.id IS NULL;

SELECT o.id AS IdOrdine,o.data_ordine,o.importo
FROM world.clienti c
RIGHT JOIN world.ordini o ON c.id = o.id_cliente
WHERE c.id IS NULL;

