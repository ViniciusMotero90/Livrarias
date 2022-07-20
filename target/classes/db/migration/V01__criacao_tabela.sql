CREATE TABLE tb_livro(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
autor VARCHAR(255) NOT NULL,
paginas INTEGER NOT NULL,
preco DECIMAL(19,2) NOT NULL);

CREATE TABLE tb_loja(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
endereco VARCHAR(255) NOT NULL,
livroId BIGINT NOT NULL,
FOREIGN KEY (livroId) REFERENCES tb_livro(id));

CREATE TABLE tb_perfil(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL
);

CREATE TABLE tb_usuario(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
perfilId BIGINT NOT NULL,
FOREIGN KEY (perfilId) REFERENCES tb_perfil(id)
);

CREATE TABLE tb_cliente(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
cpf VARCHAR(11) NOT NULL,
nome VARCHAR(255) NOT NULL,
telefone VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
livro_id BIGINT NOT NULL,
FOREIGN KEY (livro_id) REFERENCES tb_livro(id)
);