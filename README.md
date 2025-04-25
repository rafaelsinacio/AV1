Gerenciamento de Equipes e Pilotos
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar equipes e pilotos, com funcionalidades de CRUD (Create, Read, Update, Delete). A aplicação utiliza Spring Data JPA para persistência de dados e um banco de dados relacional (configurável, como H2 ou MySQL). O sistema modela uma relação de um-para-muitos entre equipes e pilotos, onde uma equipe pode ter vários pilotos associados.
Estrutura do Projeto
O projeto está organizado nos seguintes pacotes:

Rafael.Siqueira.Controller: Contém os controladores REST para Equipe e Piloto.
Rafael.Siqueira.Models: Define as entidades JPA Equipe e Piloto.
Rafael.Siqueira.Repository: Interfaces de repositório para acesso ao banco de dados.
Rafael.Siqueira.Service: Camada de serviço com a lógica de negócio.
Rafael.Siqueira: Classe principal da aplicação Spring Boot.

Arquivos do Projeto

Av1Application.java: Classe principal que inicializa a aplicação Spring Boot.
EquipeController.java: Controlador REST para operações CRUD em equipes.
PilotoController.java: Controlador REST para operações CRUD em pilotos.
Equipe.java: Modelo JPA representando uma equipe, com relação de um-para-muitos com pilotos.
Piloto.java: Modelo JPA representando um piloto, associado a uma equipe.
EquipeRepository.java: Interface JPA para operações de banco de dados com equipes.
PilotoRepository.java: Interface JPA para operações de banco de dados com pilotos.
EquipeService.java: Serviço com lógica de negócio para equipes.
PilotoService.java: Serviço com lógica de negócio para pilotos.

Pré-requisitos

Java 17 ou superior
Maven (para gerenciamento de dependências)
Banco de dados (H2 para testes ou outro banco relacional como MySQL/PostgreSQL)
IDE (recomenda-se IntelliJ IDEA ou Eclipse)
Postman ou outro cliente HTTP para testar a API

Configuração

Clone o repositório:
git clone https://github.com/rafaelsinacio/AV1.git


Configure o banco de dados:

Edite o arquivo application.properties (ou application.yml) no diretório src/main/resources para configurar o banco de dados. Exemplo para H2:spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true


Para MySQL, ajuste as propriedades conforme necessário:spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update




Instale as dependências:

Execute o comando Maven para baixar as dependências:mvn clean install




Execute a aplicação:

Rode a classe Av1Application como uma aplicação Java, ou use:mvn spring-boot:run




Acesse a API:

A API estará disponível em http://localhost:8080.



Endpoints da API
Equipe

Listar todas as equipes:
Método: GET
URL: /equipe/listar
Resposta: 200 OK com lista de equipes


Criar uma equipe:
Método: POST
URL: /equipe/criar
Corpo: JSON com nome (ex.: {"nome": "Equipe Alfa"})
Resposta: 201 Created com a equipe criada


Buscar equipe por ID:
Método: GET
URL: /equipe/{id}
Resposta: 200 OK com a equipe ou 404 Not Found


Deletar equipe:
Método: DELETE
URL: /equipe/deletar/{id}
Resposta: 204 No Content ou 500 Internal Server Error



Piloto

Listar todos os pilotos:
Método: GET
URL: /piloto/listar
Resposta: 200 OK com lista de pilotos


Criar um piloto:
Método: POST
URL: /piloto/criar
Corpo: JSON com nome, idade, categoria, e equipe_id (ex.: {"nome": "João", "idade": 25, "categoria": "F1", "equipe": {"id": 1}})
Resposta: 201 Created com o piloto criado


Buscar piloto por ID:
Método: GET
URL: /piloto/{id}
Resposta: 200 OK com o piloto ou 404 Not Found


Deletar piloto:
Método: DELETE
URL: /piloto/deletar/{id}
Resposta: 204 No Content ou 500 Internal Server Error



Modelo de Dados

Equipe:

id: Identificador único (Long, auto-incrementado)
nome: Nome da equipe (String)
pilotos: Lista de pilotos associados (relação um-para-muitos)


Piloto:

id: Identificador único (Long, auto-incrementado)
nome: Nome do piloto (String)
idade: Idade do piloto (Integer)
categoria: Categoria do piloto (String, ex.: "F1", "F2")
equipe: Equipe associada (relação muitos-para-um)



Relacionamentos

Uma Equipe pode ter vários Pilotos (relação @OneToMany).
Um Piloto pertence a uma única Equipe (relação @ManyToOne).
A exclusão de uma equipe remove automaticamente seus pilotos associados (cascade = CascadeType.ALL, orphanRemoval = true).

Dependências Principais

Spring Boot Starter Web: Para criar a API REST.
Spring Boot Starter Data JPA: Para persistência de dados.
H2 Database (ou outro banco configurado): Banco de dados em memória para testes.
Lombok: Para reduzir boilerplate (getters, setters, etc.).
Jackson: Para serialização/deserialização de JSON.

Testando a API

Use o Postman ou cURL para testar os endpoints.
Exemplo de requisição para criar uma equipe:curl -X POST http://localhost:8080/equipe/criar -H "Content-Type: application/json" -d '{"nome": "Equipe Ferrari"}'


Exemplo de requisição para criar um piloto:curl -X POST http://localhost:8080/piloto/criar -H "Content-Type: application/json" -d '{"nome": "Charles Leclerc", "idade": 25, "categoria": "F1", "equipe": {"id": 1}}'

