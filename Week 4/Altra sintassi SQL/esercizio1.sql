USE world;
SELECT CountryCode FROM world.countrylanguage;
-- ESERCIZIO 1:
-- Si vuole recuperare dal database WORLD le lingue parlate per nazione con la rispettiva percentuale di utilizzo;
SELECT c.Name AS Nazione, cl.Language AS Lingua, cl.Percentage AS Percentuale
FROM countrylanguage cl
JOIN country c ON cl.CountryCode = c.Code
ORDER BY c.Name, cl.Percentage DESC;

-- ESERCIZIO 2:
-- Si vuole recuperare dal database WORLD le nazioni e la percentuale della lingua più parlata;
SELECT c.Name AS Nazione, MAX(cl.Percentage) AS PercentualeMassima
FROM countrylanguage cl
JOIN country c ON cl.CountryCode = c.Code
GROUP BY c.Name;

-- ESERCIZIO 3:
-- Unire gli esercizi 1e2 facendole diventare subQuery per mostrare la lingua più parlata di una nazione con la percentuale;
SELECT c.Name AS Nazione, cl.Language AS LinguaPiuParlata, cl.Percentage AS Percentuale
FROM countrylanguage cl
JOIN country c ON cl.CountryCode = c.Code
WHERE
    (cl.CountryCode, cl.Percentage) IN (
        SELECT cl2.CountryCode, MAX(cl2.Percentage)
        FROM countrylanguage cl2
        GROUP BY cl2.CountryCode
    )
ORDER BY c.Name;

