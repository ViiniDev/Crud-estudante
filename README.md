# CRUD Estudante

API REST desenvolvida em Java com Spring Boot para cadastro e gerenciamento de estudantes interessados em uma carteira estudantil. O projeto utiliza arquitetura em camadas e persistência com PostgreSQL.

## Funcionalidades

- Cadastro de estudante.
- Listagem de estudantes.
- Atualização de dados cadastrais.
- Remoção de estudante por ID.
- Uso de DTOs para entrada e resposta.
- Persistência em banco PostgreSQL.

## Tecnologias

- Java 17
- Spring Boot 3.2.2
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## Estrutura do Projeto

```text
src/main/java/com/projeto/carteirinha
├── controllers
│   └── EstudanteController.java
├── entity
│   └── Estudante.java
├── repository
│   ├── EstudanteRepository.java
│   ├── EstudanteRequestDTO.java
│   └── EstudanteResponseDTO.java
├── service
│   └── EstudanteService.java
└── CarteirinhaApplication.java
```

## Configuração do Banco

Crie um banco PostgreSQL chamado `estudantes`:

```sql
CREATE DATABASE estudantes;
```

As configurações podem ser informadas por variáveis de ambiente:

```bash
DB_URL=jdbc:postgresql://localhost:5432/estudantes
DB_USER=postgres
DB_PASSWORD=sua_senha
```

## Como Executar

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Endpoints

### Criar estudante

```http
POST /carteirinhas
```

```json
{
  "nome": "Ana Silva",
  "email": "ana@email.com",
  "matricula": 12345,
  "endereco": "Av. Principal, 100"
}
```

### Listar estudantes

```http
GET /carteirinhas
```

### Atualizar estudante

```http
PUT /carteirinhas
```

```json
{
  "id": 1,
  "nome": "Ana Silva",
  "email": "ana.silva@email.com",
  "matricula": 12345,
  "endereco": "Rua Atualizada, 200"
}
```

### Remover estudante

```http
DELETE /carteirinhas/{id}
```

## Melhorias Futuras

- Adicionar validações nos DTOs.
- Criar tratamento global de exceções.
- Adicionar testes de controller e service.
- Documentar a API com Swagger/OpenAPI.
