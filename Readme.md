```markdown name=README.md url=https://github.com/FabriciosViana/desafio-todolist/blob/master/README.md
# Desafio TO‑DO List — API

API REST em Java (Spring Boot) para gerenciar uma lista de tarefas (TO‑DO). Fornece endpoints para criar, listar, atualizar e remover tarefas, persistindo os dados em um banco relacional (MySQL).

## Features
- CRUD de tarefas (criar, ler, atualizar, deletar)
- Persistência via Spring Data JPA
- Construído com Spring Boot 3 e Java 17
- Configuração externalizável (application.properties / variáveis de ambiente)

## Stack
- Linguagem: Java 17
- Framework: Spring Boot 3.1.x
- Dependências principais: spring-boot-starter-web, spring-boot-starter-data-jpa, mysql-connector-j, lombok

## Requisitos
- Java 17+
- Maven (ou usar o wrapper `./mvnw`)
- MySQL (ou outro banco compatível com JDBC)
- (opcional) Docker

## Rápido — rodar localmente
1. Configure o banco de dados (MySQL) e crie um schema/usuário.
2. Ajuste as propriedades de conexão (veja sessão "Configuração").
3. Rodar com o wrapper Maven:
```bash
# rodar diretamente
./mvnw spring-boot:run

# ou buildar e executar o jar
./mvnw package
java -jar target/*.jar
```

Para rodar testes:
```bash
./mvnw test
```

## Configuração (exemplo)
Crie/edite `src/main/resources/application.properties` ou passe variáveis de ambiente:

Exemplo application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/desafio_todolist?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# porta opcional
server.port=8080
```

Você também pode usar variáveis de ambiente com o mesmo nome (SPRING_DATASOURCE_URL, etc).

## Endpoints (exemplos)
Os nomes/rotas abaixo são um exemplo comum para uma API de tarefas. Confirme os controllers no código para as rotas exatas; posso extrair e preencher automaticamente se desejar.

- GET /tasks
  - Lista todas as tarefas
  - Exemplo:
    ```bash
    curl -s http://localhost:8080/tasks
    ```

- GET /tasks/{id}
  - Detalhe de uma tarefa

- POST /tasks
  - Cria uma nova tarefa
  - Exemplo payload:
    ```json
    {
      "title": "Comprar leite",
      "description": "Leite desnatado 1L",
      "completed": false
    }
    ```
  - Exemplo curl:
    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"title":"Comprar leite","description":"Leite 1L","completed":false}' http://localhost:8080/tasks
    ```

- PUT /tasks/{id}
  - Atualiza uma tarefa

- DELETE /tasks/{id}
  - Remove uma tarefa

Se preferir, eu posso abrir os controllers em `src/main/java/br/com/fabricioviana/desafiotodolist` e listar exatamente as rotas implementadas.

## Docker (opcional)
Exemplo simples para empacotar o jar e rodar:
```Dockerfile
FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
Build & run:
```bash
./mvnw package
docker build -t desafio-todolist .
docker run -e SPRING_DATASOURCE_URL="jdbc:mysql://host:3306/db" -e SPRING_DATASOURCE_USERNAME=user -e SPRING_DATASOURCE_PASSWORD=pass -p 8080:8080 desafio-todolist
```

## Testes
- Executar suite de testes:
```bash
./mvnw test
```

## Observações e próximos passos
- Verifique se há arquivo `application.properties` em `src/main/resources`. Se não existir, adicione conforme o exemplo acima.
- Se usar migrations (Flyway/Liquibase), adicione/descrição aqui. Atualmente o projeto usa JPA com configuração `ddl-auto` no exemplo acima.
- Posso inspecionar o código e atualizar automaticamente o README com as rotas reais, exemplos de requests/responses e instruções de seed/DB se você quiser.

## Contribuição
1. Fork this repo
2. Crie uma branch feature: `git checkout -b feature/nome-da-feature`
3. Commit e PR
4. Certifique-se de rodar os testes

## Contato
Autor: Fabricio Viana (ver repositório)
```

O README acima cobre descrição, stack, como rodar, configuração e exemplos de endpoints. Quer que eu adicione as rotas exatas diretamente extrasindo dos controllers e commit esse README no repositório?
