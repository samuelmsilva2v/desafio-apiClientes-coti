# Desafio Final Coti Informática - API Clientes

API RESTful desenvolvida em Java 21 utilizando o framework Spring Boot para gerenciar o cadastro de clientes e seus endereços. O projeto foi estruturado seguindo os princípios do **Domain-Driven Design (DDD)** e implementa operações de mensageria com RabbitMQ, além de validação de dados e persistência em um banco de dados relacional.

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
* Back-end:
  * Java 21
  * Spring Boot 3.3.5
  * Spring Data JPA
  * Spring Web
  * Spring AMQP (RabbitMQ)
  * Bean Validation
  * ModelMapper
* Banco de dados:
  * PostgreSQL
  * MongoDB
* Mensageria:
  * RabbitMQ
* Ferramentas:
  * Maven
  * Swagger/OpenAPI para documentação
  * Postman para testes  

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

## Requisitos

* Java 21 ou superior.
* Maven para gerenciamento de dependências.
* PostgreSQL para persistência dos dados.
* MongoDB para gravação de logs.

### Executando o projeto:

1. Clone o repositório:
```bash
git clone https://github.com/samuelmsilva2v/desafio-apiClientes-coti.git
cd api-clientes-coti
```
2. Execute os testes:
```bash
./mvnw test
```
3. Compile e inicie o projeto:
```bash
mvn clean install
mvn spring-boot:run
```

## Estrutura do Projeto
O projeto segue uma estrutura modular baseada nos princípios de **Domain-Driven Design (DDD)**, separando responsabilidades entre `application`, `domain` e `infrastructure`. Abaixo está a organização detalhada:

```plaintext
├── application: Camada responsável por expor os endpoints REST e lidar com exceções.
│   ├── controllers: Controladores REST para lidar com as requisições HTTP.
│   ├── handlers: Tratamento global de exceções.
│   └── exceptions: Classes para personalizar erros específicos.
├── domain: Contém a lógica de negócios e os modelos principais do sistema.
│   ├── models: Define entidades, coleções e DTOs.
│   │   ├── collections: Classes para trabalhar com MongoDB ou coleções análogas.
│   │   ├── dtos: DTOs para entrada e saída de dados.
│   │   └── entities: Entidades que mapeiam o domínio.
│   ├── services: Implementação e interfaces para lógica de negócios.
│       ├── impl: Implementações dos serviços.
│       └── interfaces: Interfaces que definem os métodos dos serviços.
├── infrastructure: Camada de infraestrutura e integração com ferramentas externas.
│   ├── components: Classes auxiliares e ferramentas, como RabbitMQ.
│   ├── configurations: Configurações de beans e propriedades.
│   └── repositories: Interfaces de acesso ao banco de dados.
└── DesafioApiClientesCotiApplication.java: Classe principal do projeto.
```

### Autor
- Samuel Maciel da Silva
  - [LinkedIn](https://www.linkedin.com/in/samuelmsilva2v/)
  - [E-mail](mailto:samuelmsilva@outlook.com.br)
