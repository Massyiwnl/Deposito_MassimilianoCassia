USE world;
--

SELECT city.Name AS Info, country.Name AS Dettaglio
FROM city
JOIN country ON city.CountryCode = country.Code
UNION
SELECT city.Name AS Info, countrylanguage.Language AS Dettaglio
FROM city
JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode;

--

SELECT country.Name AS Nazione, COUNT(city.ID) AS NumeroCitta
FROM country
JOIN city ON city.CountryCode = country.Code
GROUP BY country.Name
UNION
SELECT country.Name AS Nazione, NULL AS NumeroCitta
FROM country;

    
--

SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.GovernmentForm LIKE '%Republic%' AND country.LifeExpectancy > 70
UNION
SELECT country.Name AS Nazione, NULL AS Lingua
FROM country
WHERE country.GovernmentForm LIKE '%Republic%' AND country.LifeExpectancy > 70;

