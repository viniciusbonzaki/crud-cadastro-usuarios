# crud-cadastro-usuarios

API REST desenvolvida em **Java 17** com **Spring Boot** para o gerenciamento de usuários, implementando as operações básicas de um CRUD (*Create, Read, Update e Delete*).

O projeto foi desenvolvido com base em um conteúdo educacional do YouTube e expandido incrementalmente com a implementação de novas funcionalidades, organização em camadas e tratamento de exceções. O desenvolvimento também foi acompanhado por commits e pushes frequentes no GitHub, registrando a evolução do projeto ao longo do tempo.

Este repositório tem como objetivo consolidar conhecimentos em desenvolvimento Backend, construção de APIs REST, aplicação de regras de negócio, persistência de dados e boas práticas de organização de código.

**Conteúdo de referência:** [Javanauta](https://www.youtube.com/@javanauta) — [
CRUD Java com Spring Boot 2025 | Aprenda o Projeto QUE TODO DEV PRECISA TER no Portfólio!](https://www.youtube.com/watch?v=yW7RrWfUeHE).

## 🎯 Objetivos

- Desenvolver uma API REST para o cadastro e gerenciamento de usuários.
- Implementar as operações CRUD utilizando os métodos HTTP apropriados.
- Aplicar uma arquitetura em camadas, separando as responsabilidades da aplicação.
- Utilizar DTOs (*Data Transfer Objects*) para controlar os dados expostos pela API.
- Centralizar o tratamento de exceções, proporcionando respostas mais consistentes para as requisições.
- Implementar conversões entre DTOs e entidades, mantendo a separação entre a camada de apresentação e o modelo de persistência.
- Integrar a aplicação a um banco de dados PostgreSQL para armazenar as informações dos usuários.
- Praticar o desenvolvimento incremental, utilizando Git e GitHub para versionamento e acompanhamento da evolução do projeto.

## 🛠️ Tecnologias utilizadas

- **Java** — linguagem de programação utilizada no desenvolvimento da API.
- **Spring Boot** — framework utilizado para estruturar e desenvolver a aplicação backend.
- **Gradle** — ferramenta de automação de build e gerenciamento de dependências.
- **PostgreSQL** — banco de dados relacional utilizado para a persistência das informações.
- **Git** — ferramenta de controle de versão utilizada durante o desenvolvimento.
- **GitHub** — plataforma utilizada para hospedar o repositório e documentar a evolução do projeto.

## 📂 Arquitetura e organização do projeto

O projeto está organizado em camadas, buscando separar as responsabilidades relacionadas às requisições HTTP, às regras de negócio, à persistência de dados e ao tratamento de exceções.

Essa organização facilita a manutenção do código, favorece a reutilização de componentes e torna mais clara a comunicação entre as diferentes partes da aplicação.

### Business

A camada Business concentra as regras de negócio e a lógica necessária para executar as operações solicitadas pelos endpoints. Também é responsável pela transformação dos dados entre os objetos utilizados na API e as entidades persistidas no banco de dados.

**Principais componentes:**

- **`UsuarioService`** — contém as regras de negócio relacionadas ao cadastro, à consulta, à atualização e à exclusão de usuários. Atua como intermediário entre o controller e a camada de persistência.
- **`dto/UsuarioDTO`** — define os dados de usuário que podem ser transferidos entre a API e as demais camadas. Permite controlar quais informações são expostas nas requisições e respostas, evitando a exposição desnecessária de dados internos da entidade.
- **`converter/UsuarioConverter`** — centraliza a conversão de DTO para entidade e de entidade para DTO. Também realiza a atualização dos dados de uma entidade existente durante a operação de alteração de usuário.

### Infrastructure

A camada Infrastructure reúne os componentes responsáveis pela representação dos dados, pelo acesso ao banco de dados e pela definição de exceções específicas da aplicação.

**Principais componentes:**

- **`entity/Usuario`** — representa a entidade principal do projeto, contendo os atributos `id`, `nome` e `email`, utilizados no cadastro e gerenciamento dos usuários.
- **`repository/UsuarioRepository`** — disponibiliza as operações de acesso aos dados dos usuários, permitindo a comunicação com o banco de dados PostgreSQL por meio da abstração de repositório utilizada pela aplicação.
- **`exceptions/ResourceNotFoundException`** — representa situações em que um recurso solicitado não é encontrado, como uma tentativa de consultar ou alterar um usuário inexistente.
- **`exceptions/ConflictException`** — representa situações de conflito relacionadas às regras da aplicação, como uma tentativa de cadastrar um usuário com um e-mail já utilizado, caso essa validação esteja implementada no serviço.

### Controller

A camada Controller é responsável por receber as requisições HTTP, disponibilizar os endpoints da API e encaminhar as operações para a camada de negócio. Também define as respostas que serão retornadas aos clientes.

**Principais componentes:**

- **`UsuarioController`** — disponibiliza os endpoints para cadastrar, consultar, atualizar e excluir usuários. Encaminha as solicitações ao `UsuarioService`, mantendo as regras de negócio separadas da camada HTTP.
- **`GlobalExceptionHandler`** — centraliza o tratamento de exceções da aplicação, permitindo converter erros lançados pelas demais camadas em respostas HTTP apropriadas e padronizadas.

## 🌐 Endpoints da API

A API disponibiliza operações para cadastro, consulta, alteração e exclusão de usuários.

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| `POST` | `/usuarios` | Cadastra um novo usuário. |
| `GET` | `/usuarios?email={email}` | Consulta um usuário pelo e-mail. |
| `PUT` | `/usuarios/id={id}` | Atualiza os dados de um usuário identificado pelo ID. |
| `DELETE` | `/usuarios?email={email}` | Exclui um usuário pelo e-mail. |

**Observações:**
- No `GET` e no `DELETE`, o e-mail é utilizado como critério de identificação do usuário.
- No `PUT`, o ID é utilizado para identificar o usuário que será atualizado.
- Os códigos HTTP retornados e o formato dos corpos das requisições e respostas dependem da implementação dos endpoints.

## 📚 Aprendizados

O desenvolvimento deste projeto permite explorar conceitos fundamentais do desenvolvimento Backend com Java e Spring Boot, incluindo:

- **Desenvolvimento de APIs REST:** criação e organização de endpoints para operações de cadastro, consulta, atualização e exclusão.
- **Métodos HTTP:** utilização de `POST`, `GET`, `PUT` e `DELETE` de acordo com a finalidade de cada operação.
- **Arquitetura em camadas:** separação de responsabilidades entre Controller, Business e Infrastructure.
- **Regras de negócio:** centralização da lógica de aplicação em uma camada de serviço.
- **DTOs e entidades:** distinção entre os objetos utilizados na comunicação da API e os modelos persistidos no banco de dados.
- **Conversão de objetos:** implementação de conversores para mapear dados entre DTOs e entidades.
- **Persistência de dados:** integração com PostgreSQL e utilização de um repositório para acesso aos dados.
- **Tratamento global de exceções:** organização do tratamento de erros e conversão de exceções em respostas HTTP.
- **Integridade dos dados:** tratamento de situações como recursos inexistentes e conflitos de negócio, conforme as validações implementadas.
- **Gerenciamento de dependências e build:** utilização do Gradle para estruturar e executar o projeto.
- **Versionamento de código:** uso do Git e do GitHub para registrar alterações e acompanhar a evolução do desenvolvimento.

## 📌 Contexto do projeto

Desenvolvido como projeto de estudo e portfólio, com foco na evolução prática dos conhecimentos em Java, Spring Boot e desenvolvimento de APIs REST.
