#1.1 - Inserir dados na tabela Fornecedor:

CREATE SCHEMA lojavirtual_hybris_2;

CREATE TABLE IF NOT EXISTS `lojavirtual_hybris_2`.`Fornecedor` (
  `idFornecedor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(200) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idFornecedor`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lojavirtual_hybris_2`.`Estoque` (
  `idEstoque` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idEstoque`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lojavirtual_hybris_2`.`TipoProduto` (
  `idTipoProduto` INT NOT NULL AUTO_INCREMENT,
  `fisico` TINYINT(1) NOT NULL,  -- 0 para não físico, 1 para físico
  PRIMARY KEY (`idTipoProduto`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lojavirtual_hybris_2`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `TipoProduto_idTipoProduto` INT NOT NULL,
  `Estoque_idEstoque` INT NOT NULL,
  `Fornecedor_idFornecedor` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
  FOREIGN KEY (`TipoProduto_idTipoProduto`) 
    REFERENCES `lojavirtual_hybris_2`.`TipoProduto` (`idTipoProduto`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
  FOREIGN KEY (`Estoque_idEstoque`) 
    REFERENCES `lojavirtual_hybris_2`.`Estoque` (`idEstoque`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
  FOREIGN KEY (`Fornecedor_idFornecedor`) 
    REFERENCES `lojavirtual_hybris_2`.`Fornecedor` (`idFornecedor`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE
) ENGINE = InnoDB;

INSERT INTO `lojavirtual_hybris_2`.`Fornecedor` (`nome`, `endereco`, `telefone`) 
VALUES 
('Fornecedor A', 'Rua 1, 123', '1111-1111'),
('Fornecedor B', 'Rua 2, 234', '2222-2222'),
('Fornecedor C', 'Rua 3, 345', '3333-3333'),
('Fornecedor D', 'Rua 4, 456', '4444-4444'),
('Fornecedor E', 'Rua 5, 567', '5555-5555');

# Atividade 2 - Selecionar os 3 primeiros produtos

SELECT * FROM `lojavirtual_hybris_2`.`Produto`
ORDER BY `idProduto` LIMIT 3;

# Atividade 3 - Selecionar os produtos com mais estoque
SELECT P.* FROM `lojavirtual_hybris_2`.`Produto` P
JOIN `lojavirtual_hybris_2`.`Estoque` E ON P.`Estoque_idEstoque` = E.`idEstoque`
ORDER BY E.`quantidade` DESC;

# Atividade 4 - Selecionar todos os produtos do fornecedor 2
SELECT * FROM `lojavirtual_hybris_2`.`Produto`
WHERE `Fornecedor_idFornecedor` = 2;

# Atividade 5 - Deletar produtos do fornecedor 3 com um nome específico
DELETE FROM `lojavirtual_hybris_2`.`Produto`
WHERE `Fornecedor_idFornecedor` = 3 AND `nome` = 'Nome do Produto';

