DROP TABLE IF EXISTS region;

CREATE TABLE region (id INT UNIQUE Primary Key,
                      name VARCHAR(255) NOT NULL,
                     abbreviatedName VARCHAR(255) DEFAULT NULL
);