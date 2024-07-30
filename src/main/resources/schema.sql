DROP TABLE IF EXISTS criteria;
DROP TABLE IF EXISTS filter;


CREATE TABLE filter (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);


CREATE TABLE criteria (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          criteria_type VARCHAR(255),
                          criteria_value VARCHAR(255),
                          filter_id BIGINT,
                          FOREIGN KEY (filter_id) REFERENCES filter(id)

                      );
