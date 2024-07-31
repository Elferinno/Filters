DROP TABLE IF EXISTS criteria;
DROP TABLE IF EXISTS filter;


CREATE TABLE filter (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);


CREATE TABLE criteria (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          criteria_type VARCHAR(255) NOT NULL,
                          criteria_value VARCHAR(255) NOT NULL,
                          condition VARCHAR(255) NOT NULL,
                          filter_id BIGINT NOT NULL,
                          FOREIGN KEY (filter_id) REFERENCES filter(id)

                      );
