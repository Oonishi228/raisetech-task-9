DROP TABLE IF EXISTS users;

CREATE TABLE users (
   id int unsigned AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   residence VARCHAR(20) NOT NULL,
   PRIMARY KEY(id)
);

INSERT INTO users (id, name, residence) VALUES (1, "koyama", "東京");
INSERT INTO users (id, name, residence) VALUES (2, "tanaka", "千葉");
INSERT INTO users (id, name, residence) VALUES (3, "suzuki", "埼玉");
INSERT INTO users (id, name, residence) VALUES (4, "satou", "東京");
INSERT INTO users (id, name, residence) VALUES (5, "watanabe", "大阪");
INSERT INTO users (id, name, residence) VALUES (6, "kawaguti", "東京");
