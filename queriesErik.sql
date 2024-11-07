#1
INSERT INTO lojavirtual_hybris.Fornecedor (idFornecedores, nome) VALUES ('2', 'Fornecedor 2');
INSERT INTO lojavirtual_hybris.Fornecedor (idFornecedores, nome) VALUES ('3', 'Fornecedor 3');
INSERT INTO lojavirtual_hybris.Fornecedor (idFornecedores, nome) VALUES ('4', 'Fornecedor 4');
INSERT INTO lojavirtual_hybris.Fornecedor (idFornecedores, nome) VALUES ('5', 'Fornecedor 5');
INSERT INTO lojavirtual_hybris.Fornecedor (idFornecedores, nome) VALUES ('6', 'Fornecedor 6');

INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('2', '200');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('3', '300');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('4', '400');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('5', '500');
INSERT INTO lojavirtual_hybris.Estoque (idEstoque, quantidade) VALUES ('6', '600');

INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('3', '2');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('4', '3');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('5', '4');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('6', '5');
INSERT INTO lojavirtual_hybris.TipoProduto (idTipoProduto, fisico) VALUES ('7', '6');

INSERT INTO lojavirtual_hybris.Produto (idProduto, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto, nome) VALUES ('124', '2', '2', '3', 'Produto 2');
INSERT INTO lojavirtual_hybris.Produto (idProduto, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto, nome) VALUES ('125', '3', '3', '4', 'Produto 3');
INSERT INTO lojavirtual_hybris.Produto (idProduto, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto, nome) VALUES ('126', '4', '4', '5', 'Produto 4');
INSERT INTO lojavirtual_hybris.Produto (idProduto, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto, nome) VALUES ('127', '5', '5', '6', 'Produto 5');
INSERT INTO lojavirtual_hybris.Produto (idProduto, Fornecedor_idFornecedor, Estoque_idEstoque, TipoProduto_idTipoProduto, nome) VALUES ('128', '6', '6', '7', 'Produto 6');

#2
-- SELECT * FROM lojavirtual_hybris.Produto ORDER BY idProduto LIMIT 3;

#3
-- SELECT produto.idProduto, produto.nome, estoque.quantidade FROM lojavirtual_hybris.Produto AS produto JOIN lojavirtual_hybris.Estoque AS estoque ON produto.Estoque_idEstoque = estoque.idEstoque ORDER BY estoque.quantidade DESC;

#4
-- SELECT * FROM lojavirtual_hybris.Produto WHERE Fornecedor_idFornecedor = 2;

SELECT * FROM lojavirtual_hybris.Produto

#5
-- DELETE FROM lojavirtual_hybris.Produto AS produto WHERE produto.Fornecedor_idFornecedor = 3 AND produto.nome = 'Produto E';