-- Esercizio2:
USE world;
-- recuperare e mostrare le città con il codice della nazione che indica l'utente. Inoltre l'utente può decidere:

-- l'ordine con cui ordinare le città in maniera decrescente o meno;
SELECT city.Name AS Citta, city.CountryCode, city.Population
FROM city
WHERE city.CountryCode = 'ITA'
ORDER BY city.Population DESC;  

-- se filtrare le città per un minimo di popolazione;
SELECT city.Name AS Citta, city.CountryCode, city.Population
FROM city
WHERE city.CountryCode = 'ITA'
  AND city.Population >= 100000   -- Cambia il numero a seconda del filtro utente
ORDER BY city.Population DESC;   -- O ASC per crescente

-- se mostrare il nome della nazione a cui fa riferimento il code;
SELECT city.Name AS Citta, city.CountryCode, country.Name AS Nazione, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.CountryCode = 'ITA'
  AND city.Population >= 100000    -- opzionale
ORDER BY city.Population DESC;    -- O ASC per crescente

