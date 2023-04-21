CREATE DATABASE gefico_a3;
USE gefico_a3;

CREATE TABLE `tb_Usuario` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Login` varchar(30) NOT NULL,
	`Senha` varchar(50) NOT NULL,
    `ADM` bit DEFAULT 0,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_Cliente` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Nome` varchar(200) NOT NULL,
	`CPF` varchar(14) NOT NULL UNIQUE,
	`Idade` tinyint NOT NULL,
	`Preferencia` bit NOT NULL,
	`CEP` varchar(9) NOT NULL,
	`Logradouro` varchar(500) NOT NULL,
	`Cidade` varchar(100) NOT NULL,
	`UF` varchar(2) NOT NULL,
	`Bairro` varchar(100) NOT NULL,
	`Numero` int NOT NULL,
	`Complemento` varchar(100),
	`Telefone` varchar(11) NOT NULL,
	`Email` varchar(100) NOT NULL,
	`idUsuario` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_Pedidos` (
	`id` int NOT NULL AUTO_INCREMENT,
	`Local` varchar(100) NOT NULL,
	`Tipo` varchar(50) NOT NULL,
	`dataAgendamento` DATE NOT NULL,
	`Horario` TIME NOT NULL,
	`idCliente` int NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_Cliente` ADD CONSTRAINT `tb_Cliente_fk0` FOREIGN KEY (`idUsuario`) REFERENCES `tb_Usuario`(`id`);

ALTER TABLE `tb_Pedidos` ADD CONSTRAINT `tb_Pedidos_fk0` FOREIGN KEY (`idCliente`) REFERENCES `tb_Cliente`(`id`);




