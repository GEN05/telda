DROP TABLE IF EXISTS region;

CREATE TABLE region (id INT,
                      name VARCHAR(255) NOT NULL,
                     abbreviatedName VARCHAR(255) DEFAULT NULL
);