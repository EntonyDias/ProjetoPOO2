create database if not exists dbprojeto;
use dbprojeto;

create table if not exists tbusuario (
	pkusuario int not null primary key auto_increment,
    nome varchar (60),
    login varchar (40) unique not null,
    senha varchar (40) not null,
    datanasc date,
    ativo boolean default true
);

insert into tbusuario(
	nome, login, senha, datanasc
) values ("Lily", "Lily", "Lily", "2024-09-06")