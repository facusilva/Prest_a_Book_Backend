DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS editorial;
DROP TABLE IF EXISTS container;
DROP TABLE IF EXISTS drawer;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS wrote;
DROP TABLE IF EXISTS wishes;
DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS roles;

CREATE TABLE users(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_roles INT NOT NULL,
username VARCHAR(60) NOT NULL,
psswd VARCHAR(100) NOT NULL, 
email VARCHAR(60) NOT NULL,
real_name VARCHAR(60) NOT NULL,
surname VARCHAR(80),
birth_date DATE,
gender ENUM('H','M', 'otro')
);

CREATE TABLE editorial(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
editorial_name VARCHAR (60) NOT NULL,
country VARCHAR(40),
id_user INT NOT NULL,
FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE container(
id INT PRIMARY KEY NOT NULL,
container_name VARCHAR(50) NOT NULL
);

CREATE TABLE drawer(
id VARCHAR(5) PRIMARY KEY NOT NULL,
id_container INT NOT NULL,
FOREIGN KEY (id_container) REFERENCES container(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
ISBN VARCHAR(13) NOT NULL,
title VARCHAR(40) NOT NULL,
num_pages INT NOT NULL,
genre VARCHAR(40),
id_user INT NOT NULL,
id_editorial INT NOT NULL,
id_drawer VARCHAR(5) NOT NULL,
FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_editorial) REFERENCES editorial(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_drawer) REFERENCES drawer(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE author(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
author_name VARCHAR(60) NOT NULL,
surname VARCHAR(80) NOT NULL,
birth_date DATE,
nationality VARCHAR(40),
descr TEXT,
gender ENUM('H','M', 'otro')
);

CREATE TABLE wrote(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_book INT NOT NULL,
id_author INT NOT NULL,
FOREIGN KEY (id_book) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_author) REFERENCES author(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE wishes(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_book INT NOT NULL,
id_user INT NOT NULL,
FOREIGN KEY (id_book) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE loan(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_book INT NOT NULL,
id_loaner INT NOT NULL,
id_loanee INT NOT NULL,
starting_date DATE NOT NULL,
end_date DATE,
FOREIGN KEY (id_book) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_loaner) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_loanee) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE roles(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
role_name VARCHAR(50) NOT NULL
);


insert into users (id_roles,username,psswd,email,real_name,surname,birth_date,gender) values('1','albertojilo', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','mailinventado1@gmail.com','Alberto','Jimenez','1990-04-30','H');
insert into users (id_roles,username,psswd,email,real_name,surname,birth_date,gender) values('2','facusilva', 'F123456@','mailinventado2@gmail.com','Facundo','Silva','2000-01-01','H');
insert into users (id_roles,username,psswd,email,real_name,surname,birth_date,gender) values('2','carloslafu', 'C123456@','mailinventado3@gmail.com','Carlos','Lafuente','2000-02-02','H');
insert into users (id_roles,username,psswd,email,real_name,surname,birth_date,gender) values('3','josemarin', 'J123456@','mailinventado4@gmail.com','Jose','Marin','2000-03-03','H');

insert into editorial (editorial_name,country,id_user) values('Anaya', 'Espana','1');
insert into editorial (editorial_name,country,id_user) values('Planeta', 'Espana','2');
insert into editorial (editorial_name,country,id_user) values('Edelvives', 'Espana','3');
insert into editorial (editorial_name,country,id_user) values('Rocaeditorial', 'Espana','4');

insert into container (id,container_name) values('1','Armario de la A a la K');
insert into container (id,container_name) values('2','Armario de la L a la Z');

insert into drawer (id,id_container) values('A','1');
insert into drawer (id,id_container) values('B','1');
insert into drawer (id,id_container) values('C','1');
insert into drawer (id,id_container) values('L','2');
insert into drawer (id,id_container) values('M','2');
insert into drawer (id,id_container) values('N','2');

insert into book (ISBN,title,num_pages,genre,id_user,id_editorial,id_drawer) values('9999999999999','El nombre del viento','900','Fantasia','1','1','N');
insert into book (ISBN,title,num_pages,genre,id_user,id_editorial,id_drawer) values('9888888888888','El temor de un hombre sabio','1200','Fantasia','2','1','N');
insert into book (ISBN,title,num_pages,genre,id_user,id_editorial,id_drawer) values('9777777777777','Misery','600','Terror','3','2','M');
insert into book (ISBN,title,num_pages,genre,id_user,id_editorial,id_drawer) values('9666666666666','Loba negra','800','Thriller','4','3','L');

insert into wishes (id_book,id_user) values ('1','1');
insert into wishes (id_book,id_user) values ('2','4');
insert into wishes (id_book,id_user) values ('4','3');
insert into wishes (id_book,id_user) values ('3','2');

insert into author (author_name,surname,birth_date,nationality,descr,gender) values('Patrick','Rothfuss','1975-01-01','USA','Escritor de fantasía','H');
insert into author (author_name,surname,birth_date,nationality,descr,gender) values('Stephen','King','1965-01-01','USA','Escritor de terror','H');
insert into author (author_name,surname,birth_date,nationality,descr,gender) values('Juan','Gomez-Jurado','1980-01-01','Espana','Escritor de thriller','H');

insert into wrote (id_book,id_author) values('1','1');
insert into wrote (id_book,id_author) values('2','1');
insert into wrote (id_book,id_author) values('3','3');
insert into wrote (id_book,id_author) values('4','2');

insert into loan (id_book,id_loaner,id_loanee,starting_date,end_date) values('1','1','2','2022-11-05','2022-11-11');
insert into loan (id_book,id_loaner,id_loanee,starting_date,end_date) values('2','2','4','2022-11-04','2022-11-10');
insert into loan (id_book,id_loaner,id_loanee,starting_date,end_date) values('3','4','3','2022-11-03','2022-11-07');
insert into loan (id_book,id_loaner,id_loanee,starting_date,end_date) values('4','3','1','2022-11-02','2022-11-05');


INSERT INTO roles (role_name) VALUES ('admin');
INSERT INTO roles (role_name) VALUES ('colaborator');
INSERT INTO roles (role_name) VALUES ('user');