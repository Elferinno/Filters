DROP TABLE IF EXISTS filter;
DROP TABLE IF EXISTS criteria;


CREATE TABLE filter (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

-- Create the criteria table after the filter table
CREATE TABLE criteria (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          criteria_type VARCHAR(255),
                          criteria_value VARCHAR(255),
                          filter_id BIGINT,
                          FOREIGN KEY (filter_id) REFERENCES filter(id)
);
