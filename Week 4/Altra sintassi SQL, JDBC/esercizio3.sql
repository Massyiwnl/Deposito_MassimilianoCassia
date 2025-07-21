-- Creare una view di city del database world su una query che
-- mostra le città italiane.
-- Su questa VIEW eseguire una query che mostra solo le città
-- con una popolazione inferiore ai 100k.
USE world;
CREATE VIEW italian_cities AS
SELECT *
FROM city
WHERE CountryCode = 'ITA';

SELECT *
FROM italian_cities
WHERE Population < 100000;