CREATE database apsvenda;

CREATE TABLE cliente(
	codCli int auto_increment primary key,
    nome varchar(35),
    bonus int,
    perfil char,
    status char
);

CREATE TABLE localidade(
	codLocal int auto_increment primary key,
    nome varchar(35),
    endereco varchar(80),
    telefone varchar(14)
);

CREATE TABLE produto(
	codProd int auto_increment primary key,
    codLocal int,
    descricao varchar(35),
    qtd_estoque int,
    preco_unitario float,
    
    FOREIGN KEY (codLocal) REFERENCES localidade(codLocal)
);

CREATE TABLE venda(
	codCli int,
    codProd int,
    codLocal int,
    qtd_venda int,
    valor_total float,
    data_venda date,
    
    PRIMARY KEY(codCli, codProd, codLocal),
    FOREIGN KEY (codCli) REFERENCES cliente(codCli),
    FOREIGN KEY (codProd) REFERENCES produto(codProd),
    FOREIGN KEY (codLocal) REFERENCES localidade(codLocal)
);

DROP TABLE venda;

CREATE TABLE desconto(
	id_desconto int auto_increment primary key,
    codProd int,
    percentual int,
    qtd_min int,
    qtd_max int,
    
    FOREIGN KEY(codProd) REFERENCES produto(codProd)
);

INSERT INTO cliente(nome, bonus, perfil, status) VALUES ("Camila", 200, "G", "A");
INSERT INTO cliente(nome, bonus, perfil, status) VALUES ("Oliver", 300, "P", "A");
INSERT INTO cliente(nome, bonus, perfil, status) VALUES ("Jani", 100, "M", "A");

INSERT INTO localidade(nome, endereco, telefone) VALUES ("Pão de Açúcar - Barra da Tijuca", "Barra da Tijuca", "24930774");
INSERT INTO localidade(nome, endereco, telefone) VALUES ("Pão de Açúcar - Botafogo", "Botafogo", "25515440");
INSERT INTO localidade(nome, endereco, telefone) VALUES ("Pão de Açúcar - Copacabana", "Copacabana", "25470604");
INSERT INTO localidade(nome, endereco, telefone) VALUES ("Pão de Açúcar - Americas", "Americas", "24945782");

INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(1, "Vinho Australiano Branco", 10, 49.90);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(1, "Vinho Chileno Tinto", 13, 44.90);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(2, "Iogurte Polpa CORPUS", 25, 3.49);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(2, "Iogurte Grego Tradicional", 44, 1.79);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(3, "Queijo Cream Cheese Cremoso", 12, 4.99);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(3, "Queijo Processado Prato", 8, 5.69);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(4, "Lasanha de Frango", 20, 11.25);
INSERT INTO produto(codLocal, descricao, qtd_estoque, preco_unitario) VALUES(4, "Macarrão Italiano Fusilli", 17, 7.75);

INSERT INTO desconto(codProd, percentual, qtd_min, qtd_max) VALUES (1, 30, 5, 20);
INSERT INTO desconto(codProd, percentual, qtd_min, qtd_max) VALUES (2, 20, 5, 20);
