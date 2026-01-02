# Event Control API 📅

API RESTful desenvolvida em **Java** com **Spring Boot** para o gerenciamento completo de eventos (Workshops, Conferências, Hackathons, etc.).

O principal diferencial deste projeto é a implementação da **Clean Architecture** (Arquitetura Limpa), garantindo o desacoplamento entre as regras de negócio (Core) e detalhes de implementação (Infrastructure).

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL** (ou H2 Database)
- **Docker**
- **Lombok**
- **Maven**

## 🏗️ Arquitetura (Clean Architecture)

O projeto está estruturado para isolar o domínio da aplicação:

- **Core**: Contém as Regras de Negócio, Entidades de Domínio (`Record`) e Interfaces de Gateway. Não depende de nenhum framework externo.
  - *Domain*: `Event` (Record imutável)
  - *UseCases*: `CreateEvent`, `ListEvent`, etc.
  - *Gateways*: Interfaces que definem o comportamento esperado.
  
- **Infrastructure**: Implementação técnica.
  - *Persistence*: Repositórios JPA e Entidades ORM.
  - *Web*: Controllers REST e DTOs.
  - *Configuration*: Injeção de dependência dos UseCases (Beans).

## ✨ Funcionalidades

- **Cadastro de Eventos**: Geração automática de identificador único (UUID).
- **Listagem**: Visualização de todos os eventos cadastrados.
- **Busca por ID**: Recuperação pelo ID sequencial do banco.
- **Busca por Identificador**: Recuperação pelo UUID público (segurança).
- **Atualização**: Edição de dados do evento.
- **Remoção**: Exclusão de eventos.

## 🔌 Endpoints da API

A URL base é: `/api/v1`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/v1` | Cria um novo evento (Gera UUID auto) |
| `GET` | `/api/v1` | Lista todos os eventos |
| `GET` | `/api/v1/{id}` | Busca evento pelo ID do banco |
| `GET` | `/api/v1/identifier/{uuid}` | Busca evento pelo Identificador UUID |
| `PUT` | `/api/v1/{id}` | Atualiza os dados de um evento |
| `DELETE` | `/api/v1/{id}` | Remove um evento |

## 📝 Exemplo de Uso (JSON)

### Payload para Criação (POST)
*Nota: Não é necessário enviar `id` ou `identifier`, eles são gerados pelo sistema.*

```json
{
  "name": "Workshop de Spring Boot e Clean Architecture",
  "description": "Um evento prático para aprender a estruturar APIs robustas.",
  "dateStart": "2026-01-20T14:00:00",
  "dateEnd": "2026-01-20T18:00:00",
  "eventLocal": "Auditório Tech Hub",
  "organizer": "Dev Community",
  "capacity": 50,
  "type": "WORKSHOP"
}

Resposta de Sucesso
JSON

{
  "Message: ": "Event created successfully",
  "Data List: ": {
    "id": 1,
    "name": "Workshop de Spring Boot e Clean Architecture",
    "description": "Um evento prático para aprender a estruturar APIs robustas.",
    "dateStart": "2026-01-20T14:00:00",
    "dateEnd": "2026-01-20T18:00:00",
    "identifier": "550e8400-e29b-41d4-a716-446655440000",
    "eventLocal": "Auditório Tech Hub",
    "organizer": "Dev Community",
    "capacity": 50,
    "type": "WORKSHOP"
  }
}

🔧 Como Executar
Clone o repositório:

Bash

git clone [https://github.com/seu-usuario/eventcontrol.git](https://github.com/seu-usuario/eventcontrol.git)
Entre na pasta do projeto:

Bash

cd eventcontrol
Configure o banco de dados no application.properties ou suba o container Docker (se configurado).

Execute a aplicação:

Bash

mvn spring-boot:run
