# Desafio Final Coti Informática - API Clientes

API RESTful desenvolvida em Java 21 utilizando o framework Spring Boot para gerenciar o cadastro de clientes e seus endereços. O projeto foi estruturado seguindo os princípios do Domain-Driven Design (DDD) e implementa operações de mensageria com RabbitMQ, além de validação de dados e persistência em um banco de dados relacional.

## Funcionalidades
- CRUD de Clientes:
  - Criar, atualizar, listar e deletar clientes.
- Gestão de Endereços:
  - Associar múltiplos endereços a um cliente.
- Mensageria com RabbitMQ:
  - Envio de e-mails quando algum cliente é cadastrado.
- Validação de Dados:
  - Validações de campos obrigatórios, formatos e regras de negócio.
- Logs de Processamento:
  - Registro de operações na fila de mensageria.


## Tecnologias Usadas
- Java 21
- Spring Boot 3.3.5
- Maven
- Spring Data JPA
- Spring Mail
- Lombok
- Bean Validation
- ModelMapper
- Swagger/OpenAPI
- PostgreSQL
- MongoDB
- RabbitMQ

## Endpoints e Requisições

### Endpoints 
| Método | Endpoint             | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/clientes`      | Registra um novo cliente  |
| GET    | `/api/clientes`      | Consulta todos os clientes e seus respectivos endereços  |
| GET    | `/api/clientes/{id}` | Consulta um cliente e seus respectivos endereços através do seu ID  |
| PUT    | `/api/clientes/{id}` | Atualiza um cliente através do seu ID  |
| DELETE | `/api/clientes/{id}` | Remove um cliente através do seu ID  |

### Exemplo de requisição
Payload:
```json
[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "nome": "string",
    "cpf": "string",
    "email": "string",
    "dataNascimento": "2024-11-21T03:11:52.028Z",
    "enderecos": [
      {
        "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        "logradouro": "string",
        "complemento": "string",
        "numero": "string",
        "bairro": "string",
        "cidade": "string",
        "uf": "st",
        "cep": "string"
      }
    ]
  }
]
```

## Estrutura do projeto
```plaintext
br.com.cotiinformatica
├── application
│   ├── controllers          # Controladores REST
│   ├── handlers             # Handlers
│   └── exceptions           # Exceptions
├── domain
│   ├── models               # Entidades e objetos de domínio
│   │  ├── collections       # Coleções
│   │  ├── dtos              # DTOs de entrada e saída
│   │  └── entities          # Entidades
│   └── services             # Lógica de domínio
│   │  ├── impl              # Implementação 
│   │  └── interfaces        # Métodos de serviço
├── infrastructure
│   ├── components           # Componentes
│   ├── configurations       # Configurações
│   └── repositories         # Repositórios
└── DesafioApiClientesCotiApplication.java
```

### Autor
- Samuel Maciel da Silva
  - [LinkedIn](https://www.linkedin.com/in/samuelmsilva2v/)
  - [E-mail](mailto:samuelmsilva@outlook.com.br)
