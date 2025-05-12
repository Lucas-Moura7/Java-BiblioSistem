CREATE DATABASE biblioteca_db;
USE biblioteca_db;


CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100),
    status ENUM('Disponível', 'Emprestado') DEFAULT 'Disponível'
);

INSERT INTO usuario (cpf, nome, telefone, senha) VALUES
('111.111.111-11', 'Lucas Moura', '(11)99999-9999', 12345),
('222.222.222-22', 'Ana Beatriz', '(21)98888-8888', 54321);

INSERT INTO livro (titulo, autor) VALUES
('Dom Casmurro', 'Machado de Assis'),
('O Pequeno Príncipe', 'Antoine de Saint-Exupér');

CREATE TABLE emprestimo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_livro INT,
    data_emprestimo VARCHAR(20),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_livro) REFERENCES livro(id)
);
