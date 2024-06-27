create database banco;

use banco;

CREATE TABLE `estabelecimento` (
    `nome` VARCHAR(200) NOT NULL,
    `telefone` VARCHAR(200) NOT NULL,
    `endereco` VARCHAR(200) NOT NULL,
    `email` VARCHAR(200) NOT NULL,
    `senha` VARCHAR(200) NOT NULL,
    primary key(email)
);

CREATE TABLE `agenda` (
  `nome_cliente` varchar(200) NOT NULL,
  `nome_profissional` varchar(200) NOT NULL,
  `procedimento` varchar(200) NOT NULL,
  `dia_hora` varchar(200) NOT NULL,
  `estabelecimento_email` varchar(200) NOT NULL,
  FOREIGN KEY (`estabelecimento_email`) REFERENCES `estabelecimento`(`email`)
);
