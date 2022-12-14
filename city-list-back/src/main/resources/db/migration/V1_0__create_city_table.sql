-- Create hibernate sequence
CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

-- Create table City
CREATE TABLE IF NOT EXISTS City (
	id				INT8 NOT NULL,
	Name			VARCHAR(100) NOT NULL,
	PhotoUrl		TEXT NOT NULL,

	PRIMARY KEY		(id)
);

-- Create index on city name column
CREATE INDEX idx_city_name ON City(Name);
