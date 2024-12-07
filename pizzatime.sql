CREATE DATABASE IF NOT EXISTS Pizzatime;
USE Pizzatime;

-- Felhasználók tábla
CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(25) NOT NULL,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
    permission VARCHAR(255) DEFAULT 'user',
    address VARCHAR(250) NOT NULL,
    city VARCHAR(250) NOT NULL,
    zip VARCHAR(12) NOT NULL,
    phone VARCHAR(18) NOT NULL
);

-- Pizza tábla
CREATE TABLE Pizza (
    nev VARCHAR(50) PRIMARY KEY,
    img VARCHAR(50) NOT NULL,
    ar INT NOT NULL,
    vegetarianus BOOLEAN DEFAULT FALSE
);

-- Rendelések tábla
CREATE TABLE Orders (
    az INT PRIMARY KEY AUTO_INCREMENT,
    pizzanev VARCHAR(50) NOT NULL,
    userid INT NOT NULL,
    db INT NOT NULL,
    felvetel DATETIME NOT NULL,
    kiszallitas DATETIME NULL,
    FOREIGN KEY (pizzanev) REFERENCES Pizza(nev) ON DELETE CASCADE,
    FOREIGN KEY (userid) REFERENCES User(id) ON DELETE CASCADE
);


INSERT INTO Pizza (nev, img, ar, vegetarianus) VALUES
('Sajtos', 'sajtos.jpg', 2000, TRUE),
('Sonkás', 'sonkas.jpg', 2300, FALSE), 
('Sonka-kukoricás', 'sonka_kukoricas.jpg', 2500, FALSE),
('Magyaros', 'magyaros.jpg', 2800, FALSE),
('Zöldséges', 'zoldseges.jpg', 2400, TRUE);

INSERT INTO User (username, name, email, password, permission, address, city, zip, phone) VALUES ('admin','Admin','admin@admin.com', '$2a$10$QKfV4wdkHjYe/Yf2jRXHxenaq.c.hjQLIMjqP5PcJz618snVijtwK','admin','-', '-', '-','-');
INSERT INTO User (username, name, email, password, permission, address, city, zip, phone) VALUES ('test', 'Test', 'test@test.com', '$2a$10$ikvaQjS7PKifgTDOjd9vy.3pgtswyRGkt6TyWfiYFjYDZdcN/6wei','user','-', '-', '-','-');
