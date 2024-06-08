# Product API

## Introdução

Esta API permite ao desenvolvedor adicionar, atualizar, ler e excluir produtos ou categorias do banco de dados. Criei esta API apenas para estudos e para testar conhecimentos, é provável que com o tempo eu modifique o código e consequentemente atualize este README.
## Objetivos

- Desenvolver uma API REST Java.

## 📚 Índice

- [Recursos](#-recursos)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Endpoints](#-endpoints)
    - [Consultar todas as aeronaves](#consultar-todas-as-aeronaves)
    - [Consultar uma aeronave](#consultar-uma-aeronave-por-id)
    - [Atualizar uma aeronave](#atualizar-uma-aeronave-por-id)
    - [Adicionar uma nova aeronave](#adicionar-uma-aeronave)
    - [Deletar uma aeronave](#deletar-uma-aeronave-por-id)
    - [Consultar todos os hangares](#consultar-todos-os-hangares)
    - [Consultar um hangar](#consultar-um-hangar-por-id)
    - [Adicionar um hangar](#adicionar-um-hangar)
    - [Atualizar um hangar](#atualizar-um-hangar-por-id)
    - [Adicionar uma aeronave no hangar](#adicionar-uma-aeronave-no-hangar)
    - [Remover uma aeronave do hangar](#remover-uma-aeronave-do-hangar)
    - [Remover um hangar](#deletar-um-hangar-por-id)
- [Como Executar](#-como-executar)
- [Licença](#-licença)

## Recursos

- Consultar todas as aeronaves.
- Consultar uma aeronave.
- Atualizar uma aeronave.
- Cadastrar uma nova aeronave.
- Deletar uma aeronave.
- Consultar todos os hangares.
- Consultar um hangar.
- Adicionar um hangar.
- Atualizar um hangar.
- Deletar um hangar.
- Adicionar uma aeronave no hangar.
- Remover uma aeronave do hangar.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.3.0
- MariaDB
- Maven
- Spring Web
- Hibernate

## Estrutura do Projeto

A `divisão` de camadas do projeto será:

- `config`
- `Controller`
- `Repository`
- `Entity`
- `Exception`

## 🔍 Endpoints

### Consultar todos os produtos

- **Rota:** `GET /products`
- **Descrição:** Retorna uma lista com todos os produtos juntamente com suas categorias.

Observe que nós iremos receber uma lista com todos os produtos:

```json
[
  {
    "uuid": "70c82ee4-6479-4f46-bcad-c473a74d2134",
    "price": 4590.0,
    "name": "Dell Inspiron 5000",
    "categories": [
      {
        "uuid": "d212b06e-ac3e-4959-80da-b4aba239cea5",
        "name": "Eletronics"
      },
      {
        "uuid": "727dead3-ee97-4e13-b070-3faf025c42ce",
        "name": "Computers"
      }
    ]
  },
  {
    "uuid": "ef08ffc6-c27c-4f65-bcec-0a5f91b7d142",
    "price": 33.15,
    "name": "Divertidamente 2",
    "categories": [
      {
        "uuid": "528ec4f0-2275-45b0-81a3-6a83ff657004",
        "name": "Movies"
      }
    ]
  }
]
```

[//]: # (![get all aircrafts]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/1222473e-3bab-4d04-bd7b-1cab33f75a42&#41;)

---

### Consultar um produto por id

- **Rota:** `GET /products/{id}`
- **Descrição:** Retorna um produto juntamente com suas categorias.
- **Exemplo:**

Observe que, diferente da requisição que nós fizemos anteriormente, desta vez ele retornou  apenas uma aeronave, caso não exista uma aeronave com o id que você passou, você irá receber o erro de Not Found.

[//]: # (![Screenshot from 2024-05-30 19-50-38]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/a1d19512-7bdd-49ed-aad2-40916020d09e&#41;)

---

### Adicionar um produto

- **Rota:** `POST /products`
- **Descrição:** Adiciona um produto.
- **Exemplo:**

Nesta requisição nós iremos adicionar uma nova aeronave, mas preste a atenção no campo `aircraftStatus` que está como `IN_MAINTENANCE`, pois nós iremos citar ela futuramente.

[//]: # (![Screenshot from 2024-05-30 19-52-56]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/83b18ce3-4e15-4133-af0d-f69bb639da4b&#41;)

Iremos fazer outra requisição para obter todas as aeronaves, e perceba que a aeronave que nós adicionamos anteriormente já está salva e ela é a última da lista, guarde esta informação:

[//]: # (![Screenshot from 2024-05-30 19-53-45]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/3c7e98b4-baf3-4aa6-a315-c7846e33a8d4&#41;)

---

### Atualizar um produto por id

- **Rota:** `PUT /products/{id}`
- **Descrição:** Atualiza os campos de um produto.
- **Exemplo:**

Agora nós iremos atualizar a aeronave que nós adicionamos anteriormente, você provavelmente percebeu que quando nós adicionamos esta aeronave, o campo `aircraftStatus` estava como `IN_MAINTENANCE`, mas agora nós iremos colocar este campo como
`ACTIVE`:

[//]: # (![Screenshot from 2024-05-30 19-54-58]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/9bf47567-c437-46dd-814b-8951ca94c92f&#41;)

Iremos fazer outra requisição `GET`, mas desta vez, estamos procuramos especificamente pelo id da aeronave que nós adicionamos e acabamos de atualizar:

[//]: # (![Screenshot from 2024-05-30 19-55-13]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/b10e412d-2d36-47a3-ad8c-76c66bf274c8&#41;)

---

### Deletar um produto por id

- **Rota:** `DELETE /products/{id}`
- **Descrição:** Deleta uma aeronave pelo id.

Agora nós iremos deletar a aeronave que nós adicionamos e atualizamos anteriormente:

[//]: # (![Screenshot from 2024-05-30 19-56-07]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/e514eae4-5fe4-479b-988c-3730603bb534&#41;)

Iremos fazer outra requisição `GET`, mas desta vez nós iremos obter todas as aeronaves, e você pode perceber que antes, a aeronave com id 10, que foi a que noś acabamos de apagar, ela estava na última da lista, mas agora não está mais, pois noś acabamos de apagar:

[//]: # (![Screenshot from 2024-05-30 19-56-39]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c200d6e-cd52-40d5-8b17-1aad1f7a61ec&#41;)

---

### Consultar todas as categorias

- **Rota:** `GET /categories`
- **Descrição:** Retorna uma lista com todos os hangares adicionados juntamente com todas as aeronaves que possuem no hangar.

Observe que nós iremos receber uma lista com todos os hangares e todas as aeronaves que o hangar possui:

[//]: # (![Screenshot from 2024-05-30 19-59-27]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/aa318344-535d-4d2e-a5c7-d76b9c0390cc&#41;)

---

### Consultar uma categoria por id

- **Rota:** `GET /hangars/{id}`
- **Descrição:** Retorna um hangar juntamente com todas as aeronaves que possuem no hangar.

Diferente da requisição anterior, esta requisição irá retornar apenas um hangar, se não existir um hangar com o id que você passou, você irá receber um erro de Not Found.

[//]: # (![Screenshot from 2024-05-30 19-59-39]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/4a277626-62aa-4e31-89e8-39feb496c1be&#41;)


---

### Adicionar uma categoria

- **Rota:** `POST /categories`
- **Descrição:** Adiciona um hangar.

Nesta requisição, nós iremos adicionar um hangar:

[//]: # (![Screenshot from 2024-05-30 20-07-53]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/90c7d96c-1c1c-4ffd-957b-ee3b9ccc2c56&#41;)

Agora vamos checar se realmente nós conseguimos criar o hangar, bora fazer outra requisição `GET` para retornar todos os hangares.
Olhe para o campo `aircrafts`, temos uma lista vazia, pois ainda não adicionamos nenhuma aeronave, mas isso irá mudar, fique ligado :).

[//]: # (![Screenshot from 2024-05-30 20-08-19]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/7bb25a20-2e0e-41fc-97e4-41f4a8059dde&#41;)

---

### Atualizar uma categoria por id

- **Rota:** `PUT /hangars/{id}`
- **Descrição:** Atualiza os campos do hangar pelo id.
- **Exemplo:**

Agora vamos atualizar o hangar que possui o id 2, que antes (eu não lhe mostrei) ele tinha o `name` igual a `Hangar Militar da Base Aérea de Anápolis`, mas agora nós iremos encurtar mais, iremos colocar apenas `Base Aérea de Anápolis`, perceba:

[//]: # (![Screenshot from 2024-05-30 20-01-32]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/04b4bbce-fac2-4f31-8586-3b56e028387c&#41;)

Iremos fazer outra requisição `GET` para obter especificamente o hangar com o id 2, você consegue ver que o campo foi atualizado com sucesso:

[//]: # (![Screenshot from 2024-05-30 20-05-01]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/b5bc06a6-0374-4a9c-af58-ca96cc21d2d5&#41;)

---

### Adicionar uma categoria em um produto

- **Rota:** `POST /hangars/{id}/aircrafts/{id}`
- **Descrição:** Adiciona uma aeronave em um hangar.
- **Código HTTP:** `200`

Nesta requisição, iremos adicionar uma aeronave que possui o id 10 no hangar que possui o id 4 (o hangar que nós adicionamos anteriormente):

[//]: # (![Screenshot from 2024-05-30 20-11-45]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/6514c028-d800-4069-bb55-9b4c3d6e0ec5&#41;)

Lembra que antes o nosso campo `aircrafts` estava com uma lista vazia ? Agora não está mais, pois acabamos de adicionar uma aeronave.

[//]: # (![Screenshot from 2024-05-30 20-12-08]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/22e45fa5-01ea-4645-9cd7-dc8bb46b7484&#41;)

---

### Remover uma categoria de um produto

- **Rota:** `DELETE /hangars/{id}/aircrafts/{id}`
- **Descrição:** Remove uma aeronave do hangar.

Para remover uma aeronave, a rota é a mesma da anterior, a diferença é que agora o tipo da requisição é `DELETE`, ou seja, agora nós estamos removendo a aeronave que possui id 10, do nosso hangar que possui id 4:

[//]: # (![Screenshot from 2024-05-30 20-12-28]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/167c784e-1ef8-4178-8214-1c0308993e97&#41;)

Agora o campo `aircrafts` voltou a ser uma lista vazia, pois nós acabamos de remover uma aeronave:

[//]: # (![Screenshot from 2024-05-30 20-12-43]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c68ec76-4dcc-4235-9d9c-97124cbeb588&#41;)


---

### Deletar categoria de um produto

- **Rota:** `DELETE /hangars/{id}`
- **Descrição:** Deleta um hangar pelo id.

Nesta requisição, nós iremos remover o hangar que nós adicionamos inicialmente, que possui o id 4:

[//]: # (![Screenshot from 2024-05-30 20-55-33]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/3785b58a-9eaf-49a6-b2a8-4d7a35521147&#41;)

Agora, iremos fazer outra requisição `GET`, e perceba que o hangar não está presente, pois nós acabamos de remover:

[//]: # (![Screenshot from 2024-05-30 20-56-24]&#40;https://github.com/jaoteus/hangar-api-spring/assets/128613422/9b633206-ba75-494d-8dd3-7d4502ecb609&#41;)

---

## Como Executar

Clone o repositório:
```sh
git clone https://github.com/jaoteus/hangar-api-spring.git
```

Navegue até o diretório do projeto:
```sh
cd hangarapi/
```
Agora suba o container com o Postgres com o seguinte comando (no Linux):
```sh
sudo docker-compose up -d
```
O arquivo `docker-compose.yml` já está no projeto.

Agora compile e execute a aplicação:

```sh
mvn clean install
mvn spring-boot:run
```

### 📄 Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

---