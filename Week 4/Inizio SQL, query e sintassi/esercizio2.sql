USE world;

CREATE TABLE Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione INT
);

-- Inserimento dati (INSERT INTO)
-- Inserire almeno 6 nuovi libri nella tabella Libri usando il comando SQL INSERT INTO.
-- I libri devono appartenere a generi e autori diversi, ed essere pubblicati in anni differenti.
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione) VALUES
(1, 'Il nome della rosa', 'Umberto Eco', 'Storico', 16.90, 1980),
(2, '1984', 'George Orwell', 'Distopico', 12.50, 1949),
(3, 'Orgoglio e pregiudizio', 'Jane Austen', 'Romanzo', 10.00, 1813),
(4, 'Il signore degli anelli', 'J.R.R. Tolkien', 'Fantasy', 22.00, 1954),
(5, 'Cent''anni di solitudine', 'Gabriel García Márquez', 'Letteratura', 14.75, 1967),
(6, 'Il giovane Holden', 'J.D. Salinger', 'Narrativa', 11.30, 1951);

-- Aggregazione e raggruppamento (GROUP BY)
-- Scrivere una query che, usando il comando GROUP BY, mostri per ogni genere:
-- il numero totale di libri presenti;
-- il prezzo medio dei libri appartenenti a quel genere.
-- La query dovrà restituire il risultato ordinato alfabeticamente per genere.
SELECT
  genere,
  COUNT(*) AS totale_libri,
  AVG(prezzo) AS prezzo_medio
FROM
  Libri
GROUP BY
  genere
ORDER BY
  genere ASC;

-- Ordinamento risultati (ORDER BY)
-- Scrivere una query che elenchi tutti i libri pubblicati dopo l’anno 2010 ordinati in modo decrescente 
-- per anno di pubblicazione e, in caso di anno uguale, in ordine crescente per prezzo.
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione) VALUES
(7, 'Ciao mbare', 'Massimiliano Cassia', 'Fantasy', 40.50, 2025);
SELECT *
FROM Libri
WHERE anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC, prezzo ASC;