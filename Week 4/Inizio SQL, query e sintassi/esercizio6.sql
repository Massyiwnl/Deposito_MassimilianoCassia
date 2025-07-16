USE world;
--
-- 1) Si vogliono recuperare dal database "world" la lingua e la nazione di ogni città.
SELECT city.Name AS Info, country.Name AS Dettaglio
FROM city
JOIN country ON city.CountryCode = country.Code
UNION
SELECT city.Name AS Info, countrylanguage.Language AS Dettaglio
FROM city
JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode;

--
-- 2) Si vuole recuperare il numero di città per nazione dal database "world" mostrando anche il nome della nazione e ordinarli in base al numero di città.
SELECT country.Name AS Nazione, COUNT(city.ID) AS NumeroCitta
FROM country
JOIN city ON city.CountryCode = country.Code
GROUP BY country.Name
UNION
SELECT country.Name AS Nazione, NULL AS NumeroCitta
FROM country;

    
--
-- 3) Si vuole conoscere la lista di repubbliche con aspettativa di vita maggiore dei 70 anni, inoltre si vuole visualizzare anche la lingua parlata.
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.GovernmentForm LIKE '%Republic%' AND country.LifeExpectancy > 70
UNION
SELECT country.Name AS Nazione, NULL AS Lingua
FROM country
WHERE country.GovernmentForm LIKE '%Republic%' AND country.LifeExpectancy > 70;

