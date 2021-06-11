
create database dbbiblioteca;
create schema scbiblioteca

CREATE TABLE scbiblioteca.cliente
(
    nif character(10) PRIMARY KEY,
    nombre character varying(50) NOT NULL,
    apellidos character varying(50) NOT NULL,
 ); 





set search_path to scbiblioteca;
select * from scbiblioteca.cliente;

 