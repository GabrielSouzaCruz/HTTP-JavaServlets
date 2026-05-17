drop database atividade_http;
-- 1. Cria o banco de dados (se não existir) e entra nele
CREATE DATABASE IF NOT EXISTS atividade_http DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE atividade_http;

-- =======================================================
-- 2. CRIAÇÃO DAS TABELA
-- =======================================================
-- Tabela de Postagens (Para o nosso PostController do Servlet 2)
CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    mensagem TEXT NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =======================================================
-- 3. INSERÇÃO DE DADOS DE TESTE (MOCK DATA)
-- =======================================================

-- Inserindo um post de teste
INSERT INTO posts (nome, email, mensagem) VALUES 
('Professor Emerson', 'emerson.carvalho@ifsuldeminas.edu.br', 'A arquitetura MVC com Servlets e JSON ficou excelente! Nota 10.');