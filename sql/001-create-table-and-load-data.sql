DROP TABLE IF EXISTS users;

CREATE TABLE users (
   id int unsigned AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   residence VARCHAR(20) NOT NULL,
   PRIMARY KEY(id)
);

INSERT INTO users (id, name, residence) VALUES (1, "小山", "東京");
