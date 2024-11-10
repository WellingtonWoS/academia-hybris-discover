-- -----------------------------------------------------
# Query para inserir 5 dados
-- -----------------------------------------------------
INSERT INTO lojavirtual_hybris.fornecedor (idFornecedores, nome) VALUES ('2', 'Fornecedor A');
INSERT INTO lojavirtual_hybris.fornecedor (idFornecedores, nome) VALUES ('3', 'Fornecedor B');
INSERT INTO lojavirtual_hybris.fornecedor (idFornecedores, nome) VALUES ('4', 'Fornecedor C');
INSERT INTO lojavirtual_hybris.fornecedor (idFornecedores, nome) VALUES ('5', 'Fornecedor D');
INSERT INTO lojavirtual_hybris.fornecedor (idFornecedores, nome) VALUES ('6', 'Fornecedor E');

INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('2', '100');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('3', '150');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('4', '200');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('5', '50');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('6', '300');

INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('1', '0');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('2', '1');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('3', '1');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('4', '0');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('5', '1');

INSERT INTO lojavirtual_hybris.Produto (idProduto, nome, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto) VALUES ('1', 'Produto A', '1', '1', '1');
INSERT INTO lojavirtual_hybris.Produto (idProduto, nome, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto) VALUES ('2', 'Produto B', '2', '2', '2');
INSERT INTO lojavirtual_hybris.Produto (idProduto, nome, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto) VALUES ('3', 'Produto C', '3', '3', '3');
INSERT INTO lojavirtual_hybris.Produto (idProduto, nome, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto) VALUES ('4', 'Produto D', '4', '4', '4');
INSERT INTO lojavirtual_hybris.Produto (idProduto, nome, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto) VALUES ('5', 'Produto E', '5', '5', '5');

-- -----------------------------------------------------
# Query dos 3 primeiros produtos
-- -----------------------------------------------------
SELECT * FROM lojavirtual_hybris.Produto ORDER BY idProduto LIMIT 3;

-- -----------------------------------------------------
# Query para selecionar os produtos com mais estoque
-- -----------------------------------------------------
SELECT * FROM lojavirtual_hybris.Produto ORDER BY Estoque_idEstoque DESC LIMIT 1;

-- -----------------------------------------------------
# para selecionar todos os produtos do fornecedor 2
-- -----------------------------------------------------
SELECT * FROM lojavirtual_hybris.Produto WHERE Fornecedor_idFornecedor = 2;

-- -----------------------------------------------------
# para deletar os produtos do fornecedor 3, que possuam algum nome especifico
-- -----------------------------------------------------
DELETE FROM lojavirtual_hybris.Produto WHERE Fornecedor_idFornecedor = 3 AND nome = 'Produto E';