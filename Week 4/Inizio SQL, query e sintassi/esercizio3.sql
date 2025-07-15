USE world;

CREATE TABLE Vendite (
    id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'Mela Golden', 'Frutta', 30, 0.50, '2024-07-01'),
(2, 'Banana', 'Frutta', 50, 0.35, '2024-07-01'),
(3, 'Pane Integrale', 'Panetteria', 15, 2.20, '2024-07-02'),
(4, 'Latte Intero', 'Latticini', 20, 1.15, '2024-07-02'),
(5, 'Prosciutto Crudo', 'Salumi', 10, 3.50, '2024-07-03'),
(6, 'Brioche', 'Pasticceria', 25, 1.00, '2024-07-03'),
(7, 'Yogurt Fragola', 'Latticini', 18, 0.90, '2024-07-04'),
(8, 'Mozzarella', 'Latticini', 22, 1.30, '2024-07-04'),
(9, 'Coca Cola 1L', 'Bevande', 12, 1.40, '2024-07-05'),
(10, 'Pasta Fusilli', 'Pasta', 40, 0.85, '2024-07-05');

SELECT * FROM world.vendite;
-- Scrivi le query SQL per rispondere alle seguenti richieste:

-- 		Totale vendite per categoria
SELECT 
  categoria, 
  SUM(quantita * prezzo_unitario) AS totale_vendite
FROM 
  world.vendite
GROUP BY 
  categoria;
-- Visualizza, per ogni categoria, il numero totale di vendite effettuate.


-- 		Prezzo medio per categoria
SELECT 
  categoria, 
  AVG(quantita * prezzo_unitario) AS media_venduti
FROM 
  world.vendite
GROUP BY 
  categoria;
-- Mostra, per ogni categoria, il prezzo medio dei prodotti venduti.

-- 		Quantità totale venduta per ogni prodotto
SELECT
  prodotto,
  SUM(quantita) AS quantita_totale
FROM
  world.vendite
GROUP BY
  prodotto;
-- Mostra il totale delle quantità vendute (SUM) per ciascun prodotto.

-- 		Prezzo massimo e minimo venduto nella tabella
SELECT
  MAX(prezzo_unitario) AS prezzo_massimo,
  MIN(prezzo_unitario) AS prezzo_minimo
FROM
  vendite;
-- Mostra il prezzo massimo e il prezzo minimo tra tutti i prodotti venduti.

-- 		Numero totale di righe nella tabella
SELECT
  COUNT(*) AS totale_vendite
FROM
  world.vendite;
-- Conta quante vendite sono state registrate nella tabella Vendite.

-- 		I 5 prodotti più costosi (in base al prezzo_unitario)
SELECT
  prodotto,
  prezzo_unitario
FROM
  vendite
ORDER BY
  prezzo_unitario DESC
LIMIT 5;
-- Elenca i 5 prodotti più costosi ordinati in modo decrescente rispetto al prezzo.

-- 		I 3 prodotti meno venduti per quantità totale
SELECT
  prodotto,
  SUM(quantita) AS quantita_totale
FROM
  vendite
GROUP BY
  prodotto
ORDER BY
  quantita_totale ASC
LIMIT 3;
-- Mostra i nomi dei 3 prodotti con la quantità totale più bassa venduta (usa SUM e LIMIT).