📘 Crédito Consulta API
API RESTful para consulta de créditos constituídos, desenvolvida com Spring Boot, PostgreSQL, Kafka, Docker e Swagger.

🚀 Como rodar
🔧 Pré-requisitos
Docker e Docker Compose instalados

(Opcional) Java 17+ e Maven, se quiser rodar sem Docker

▶️ Rodando com Docker (recomendado)

docker-compose up --build

A aplicação ficará disponível em:
📡 http://localhost:8080/api/creditos

O PostgreSQL estará acessível em localhost:5432 com user admin e senha admin.

💻 Rodando localmente (sem Docker)
Configure o banco PostgreSQL local:

DB: creditodb

User: admin

Pass: admin

Suba o Kafka com Docker:

docker-compose up kafka zookeeper

Rode o projeto com Maven:

mvn spring-boot:run

📬 Endpoints da API
🔍 Consultar créditos por NFS-e

GET /api/creditos/{numeroNfse}

🔍 Consultar crédito por número

GET /api/creditos/credito/{numeroCredito}

📥 Parâmetros via path
📤 Resposta JSON estruturada com os dados do crédito

📖 Documentação Swagger / OpenAPI
Acesse a documentação interativa da API:

🧾 Swagger UI:
📎 http://localhost:8080/swagger-ui.html

🔧 OpenAPI JSON:
📎 http://localhost:8080/v3/api-docs

Os endpoints são documentados automaticamente com base nos controllers Spring.

🧪 Rodando os testes

mvn clean test

✅ Testes unitários cobrem:

Lógica de serviço

Controller REST

Envio de mensagens Kafka

🐳 docker-compose incluído
Esse projeto já vem com suporte completo via Docker:

PostgreSQL

Kafka + Zookeeper

API backend

docker-compose up --build

📦 Tecnologias utilizadas
Java 17

Spring Boot 3.2

Spring Data JPA

PostgreSQL

Kafka (Producer)

Docker + Docker Compose

JUnit 5 + Mockito

Lombok

Swagger/OpenAPI via springdoc

✍️ Autor
Felipe Ricarte Magalhães