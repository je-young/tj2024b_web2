DROP TABLE IF EXISTS phonebook;
CREATE TABLE phonebook (
    pno INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL
);