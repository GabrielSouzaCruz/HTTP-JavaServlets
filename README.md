# AtividadeHTTP 🌐

Este projeto foi desenvolvido como parte da atividade prática de **Tecnologias de Desenvolvimento para Internet II** do Bacharelado em Sistemas de Informação no **IFSULDEMINAS - Campus Machado**. O objetivo principal é explorar e demonstrar, na prática, os fundamentos do protocolo HTTP utilizando a arquitetura Jakarta EE (Servlets e JSPs).

A aplicação evoluiu de um modelo acadêmico simples para uma **arquitetura web robusta e profissional**, implementando os padrões de projeto **MVC (Model-View-Controller)**, **DAO (Data Access Object)**, **Front Controller** e **Filtros Globais**, além de persistência real em banco de dados **MySQL**.

---

## 🛠️ Tecnologias Utilizadas

* **Java SE 11+ / Jakarta EE** (Servlets & JSP)
* **Apache Tomcat 10+** (Servlet Container)
* **MySQL** (Sistema Gerenciador de Banco de Dados)
* **Bootstrap 3** & **jQuery** (Interface Responsiva)
* **JSTL (JavaServer Pages Standard Tag Library)** (Renderização dinâmica nas Views)

---

## 📐 Arquitetura e Padrões de Projeto

A aplicação foi estruturada seguindo as melhores práticas da engenharia de software de mercado, dividida nos seguintes pilares fundamentais:

1.  **Mundo Real / API REST (JSON):** Centralização e padronização de endpoints técnicos utilizando o formato JSON para comunicação de dados estruturados.
2.  **Filtros Interceptadores (Pilar de Segurança):** Interceptação global de requisições para manipulação de cabeçalhos e segurança.
3.  **Front Controller (Roteamento Inteligente):** Um único ponto de entrada para gerenciar requisições da API de forma escalável.
4.  **Padrão MVC Genuíno:** Separação estrita de responsabilidades:
    * **Model:** Classes de entidade e persistência (DAO), sem qualquer código de interface ou protocolo.
    * **View:** Páginas JSP limpas, que apenas exibem dados utilizando Expression Language (`${}`).
    * **Controller:** Servlets que recebem os dados, acionam as regras de negócio/banco e encaminham (`forward`) para a View correspondente.

---

## 📂 Estrutura de Pacotes do Back-end

```text
src/main/java/
└── controller/
    ├── ApiFrontController.java   # Centraliza e roteia as chamadas da API JSON (/api/*)
    ├── GlobalFilter.java         # Filtro global que força UTF-8 e configura cabeçalhos CORS
    ├── HeadersServlet.java       # Servlet legado de análise de cabeçalhos (HTML puro)
    ├── MethodsServlet.java       # Endpoint técnico dedicado ao método HTTP OPTIONS (/methods)
    ├── PostController.java       # Controlador MVC que processa o formulário POST
    ├── SessionController.java    # Controlador MVC que gerencia cookies e estado da sessão
    └── StatusServlet.java        # Simulador dinâmico de códigos de estado HTTP (?code=X)
└── model/
    ├── Post.java                 # Entidade que encapsula os dados do formulário
    ├── ModelException.java       # Classe customizada para tratamento de exceções da camada de modelo
    └── dao/
        ├── DAOFactory.java       # Fábrica abstrata para fornecimento de instâncias do DAO
        ├── PostDAO.java          # Interface que dita o contrato de persistência do Post
        ├── MySQLPostDAO.java     # Implementação física do DAO com instruções SQL (INSERT)
        └── MySQLConnectionFactory.java # Gerenciador de conexões JDBC com o MySQL

```

---

## 🖥️ Funcionalidades Mapeadas (Os 5 Requisitos HTTP)

* **Servlet 1 - Análise de Cabeçalhos HTTP (`GET /api/headers`):** Analisa dinamicamente metadados da requisição enviada pelo navegador (User-Agent, IP do Cliente, versão do protocolo) e devolve um objeto JSON perfeitamente estruturado.
* **Servlet 2 - Corpo da Requisição (`POST /app/request-body`):** Captura parâmetros de um formulário web estilizado com Bootstrap (Nome, E-mail e Mensagem), grava os dados no banco de dados MySQL via padrão DAO e renderiza uma tela de sucesso via JSP (MVC).
* **Servlet 3 - Controle de Estado e Cookies (`GET /app/session`):** Cria e gerencia um Cookie identificador único (`usuario`). Se for o primeiro acesso, o back-end notifica que o cookie foi gerado; nas requisições seguintes, lê o cookie do navegador e exibe uma mensagem personalizada de boas-vindas.
* **Servlet 4 - Simulação de Status HTTP (`GET /status?code=X`):** Permite injetar códigos de estado HTTP customizados diretamente pela URL. Para códigos de erro (>= 400), dispara uma página de erro oficial do servidor Tomcat através do método `resp.sendError()`.
* **Servlet 5 - Métodos Suportados (`OPTIONS /methods`):** Endpoint técnico projetado para responder à pergunta exploratória do protocolo HTTP sobre as capacidades do servidor. Implementa exclusivamente o método `doOptions()`, injetando o cabeçalho HTTP `Allow: GET, POST, PUT, DELETE, OPTIONS` com status `200 OK`.

---

## 🗄️ Estrutura do Banco de Dados

Para rodar a persistência do **Servlet 2**, certifique-se de executar o seguinte script no seu servidor MySQL local (porta `3306`):

```sql
CREATE DATABASE IF NOT EXISTS atividade_http DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE atividade_http;

CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    mensagem TEXT NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

```

> ⚙️ **Configuração de Conexão:** Caso o seu MySQL possua senha, lembre-se de ajustar a variável `PASSWORD` localizada em `model.dao.MySQLConnectionFactory.java`.

---

## 🚀 Como Executar o Projeto

1. Importe o projeto no **Eclipse IDE for Enterprise Java and Web Developers** (ou sua IDE de preferência).
2. Certifique-se de que o Driver JDBC do MySQL (`mysql-connector-java-8.0.27.jar`) e as libs do Jakarta JSTL estejam na pasta `src/main/webapp/WEB-INF/lib/`.
3. Inicie o seu servidor local MySQL e execute o script de criação da tabela.
4. Clique com o botão direito no projeto -> **Run As** -> **Run on Server** selecionando o Apache Tomcat.
5. Acesse o Dashboard unificado através da URL:
`http://localhost:8080/AtividadeHTTP/`

---

## 👨‍💻 Desenvolvedor

* **Gabriel de Souza Cruz**
* Estudante de Sistemas de Informação - IFSULDEMINAS Campus Machado
