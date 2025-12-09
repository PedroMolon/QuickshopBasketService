# QuickshopBasketService

Microserviço para gerenciamento de carrinhos de compras em um sistema e-commerce.

## Descrição

Este é um microserviço Spring Boot que gerencia carrinhos de compras. Ele permite criar, visualizar, atualizar e excluir carrinhos, bem como adicionar produtos a eles. O serviço também se integra a um serviço de produtos externo para buscar informações sobre os produtos.

## Funcionalidades

*   Criar um novo carrinho de compras.
*   Obter um carrinho de compras pelo seu ID.
*   Atualizar um carrinho de compras.
*   Pagar por um carrinho de compras.
*   Excluir um carrinho de compras.
*   Obter todos os produtos do serviço de produtos externo.
*   Obter um produto pelo seu ID do serviço de produtos externo.

## Tecnologias Utilizadas

*   **Java 21**: Versão da linguagem Java utilizada.
*   **Spring Boot 4.0.0**: Framework para criação de aplicações Java.
*   **Spring Data MongoDB**: Para integração com o banco de dados NoSQL MongoDB.
*   **Spring Data Redis**: Para caching de dados.
*   **Spring WebMVC**: Para criação de APIs REST.
*   **Spring Cloud OpenFeign**: Para comunicação declarativa com outros serviços REST.
*   **SpringDoc OpenAPI**: Para geração de documentação da API.
*   **Lombok**: Para redução de código boilerplate.
*   **Docker**: Para containerização da aplicação.
*   **Maven**: Para gerenciamento de dependências e build da aplicação.

## API Endpoints

A aplicação expõe os seguintes endpoints:

### Basket

*   `GET /basket/{id}`: Obtém um carrinho pelo seu ID.
*   `POST /basket`: Cria um novo carrinho.
*   `PUT /basket/{id}`: Atualiza um carrinho existente.
*   `PUT /basket/{id}/payment`: Realiza o pagamento de um carrinho.
*   `DELETE /basket/{id}`: Deleta um carrinho.

### Produtos

*   `GET /products`: Obtém todos os produtos.
*   `GET /products/{id}`: Obtém um produto pelo seu ID.

A documentação completa da API pode ser acessada em [/swagger-ui.html](/swagger-ui.html) após a inicialização da aplicação.

## Como Executar

### Pré-requisitos

*   Java 21
*   Maven
*   Docker
*   Docker Compose

### Passos

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/seu-usuario/QuickshopBasketService.git
    cd QuickshopBasketService
    ```

2.  **Inicie os serviços de dependência com o Docker Compose:**

    Este comando irá iniciar os containers do MongoDB e Redis.

    ```bash
    docker-compose up -d
    ```

3.  **Execute a aplicação Spring Boot:**

    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Configuração

O arquivo de configuração principal é o `src/main/resources/application.yaml`. Nele, você pode configurar:

*   **MongoDB**: Host, porta e nome do banco de dados.
*   **Redis**: Host, porta e senha.
*   **Cache**: Tempo de vida do cache em Redis.
*   **URL do Cliente Platzi**: URL base da API de produtos da Platzi.

```yaml
spring:
  application:
    name: QuickshopBasketService
  mongodb:
    host: localhost
    port: 27017
    database: basket-service
  data:
    redis:
      host: localhost
      port: 6379
      password: sa

  cache:
    redis:
      time-to-live: 60000

basket:
  client:
    platzi: https://api.escuelajs.co/api/v1
```
