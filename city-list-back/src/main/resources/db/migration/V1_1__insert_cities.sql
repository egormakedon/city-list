-- Import cities.csv
COPY City(id, Name, PhotoUrl)
FROM '${data}/cities.csv'
DELIMITER ','
CSV HEADER;
