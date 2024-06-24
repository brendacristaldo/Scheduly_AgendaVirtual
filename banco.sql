create database banco;

use banco;

CREATE TABLE `estabelecimento` (
  `nome` varchar(200) NOT NULL,
  `telefone` int NOT NULL,
  `email` varchar(200) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `senha` varchar(200) NOT NULL
) ;

CREATE TABLE `agenda` (
  `nome_cliente` varchar(200) NOT NULL,
  `nome_profissional` varchar(200) NOT NULL,
  `procedimento` varchar(200) NOT NULL,
  `dia_agendamento` date NOT NULL,
  `horario` time NOT NULL
) 