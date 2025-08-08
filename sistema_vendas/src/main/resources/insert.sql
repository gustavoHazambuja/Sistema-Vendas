-- Usuários
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (1, 'Ana Souza', '1980-05-12', 2);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (2, 'Carlos Mendes', '1975-09-30', 1);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (3, 'Mariana Silva', '1990-01-20', 0);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (4, 'João Pereira', '1960-07-15', 4);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (5, 'Fernanda Lima', '1988-03-22', 3);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (6, 'Ricardo Alves', '2000-11-10', 0);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (7, 'Paula Torres', '1995-02-05', 2);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (8, 'André Oliveira', '1958-08-08', 1);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (9, 'Luciana Carvalho', '1983-12-18', 5);
INSERT INTO tb_usuario (id,nome,data_nascimento,num_dependentes) VALUES (10, 'Marcelo Costa', '1970-06-25', 0);


-- Produtos
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(101, 'Arroz 5kg', 50, 25.90, 'ALIMENTICIO');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(102, 'Feijão 1kg', 80, 7.50, 'ALIMENTICIO');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(103, 'Óleo de Motor 1L', 30, 45.00, 'AUTOMOTIVO');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(104, 'Pneu Aro 15', 20, 350.00, 'AUTOMOTIVO');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES (105, 'Vinho Tinto 750ml', 40, 60.00, 'BEBIDAS_ALCOOLICAS');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(106, 'Cerveja Lata 350ml', 200, 4.50, 'BEBIDAS_ALCOOLICAS');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(107, 'Chocolate 100g', 100, 6.90, 'ALIMENTICIO');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(108, 'Detergente 500ml', 150, 2.80, 'OUTRAS_CATEGORIAS');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(109, 'Sabão em Pó 1kg', 70, 12.50, 'OUTRAS_CATEGORIAS');
INSERT INTO tb_produto (codigo,descricao,quantidade_estoque,preco_unitario,categoria) VALUES(110, 'Refrigerante 2L', 60, 8.50, 'OUTRAS_CATEGORIAS');


-- Vendas
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (1, 1, 101);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (2, 3, 105);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (3, 4, 103);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (4, 8, 108);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (5, 9, 107);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (6, 2, 102);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (7, 5, 106);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (8, 6, 110);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (9, 7, 104);
INSERT INTO tb_venda (id,id_usuario,int_produto) VALUES (10, 10, 109);