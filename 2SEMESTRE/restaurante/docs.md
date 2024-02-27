# Documentação

É uma pequena documentação do projeto

## Como rodar

Para rodar o projeto você precisar ter instalado os seguintes softwares:

- [JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Node.js](https://nodejs.org/en/)

Antes de qualquer coisa, você vai precisar clonar o repositório.

```bash
git clone https://github.com/DutraGames/fatec-dsm-java

cd fatec-dsm-java\2SEMESTRE\restaurante
```

Instale o maven no seu computador. Em seguida instale as dependências do projeto Spring Boot e as demais dependências.

Você poderá acesso ao servidor de documentação da API através do [Swagger](#swagger).

Para ter acesso ao front-End aplicação, basta executar o seguinte comando:

```bash
cd front-end

npm install

npm run dev
```

## Swagger

A documentação da API foi utilizado o swagger para melhor apresentação e demostração de seu uso. Já que o swagger consegue fazer um preview usual de requisições.

![swagger](https://cdn.discordapp.com/attachments/1145059998897017064/1211144339988942858/image.png?ex=65ed2110&is=65daac10&hm=834817e11dd3e2199b90cd3c39d26db01ba9460cd92af7c1ce2d72c481024b87&)

Para acessar a rota do swagger basta rodar o servidor e acessar:

```bash
# A porta padrão é 8080.

http://localhost:{port}/swagger-ui/index.html
```
