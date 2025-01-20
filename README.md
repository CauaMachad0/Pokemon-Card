# 📚 Pokémon Card API

A Pokémon Card API é uma aplicação backend desenvolvida com **Java** e **Spring Boot** que permite gerenciar um banco de dados de cartas de Pokémon. A API oferece recursos para adicionar, atualizar, excluir e listar Pokémon, bem como para buscar Pokémon por nome ou tipo. Este projeto tem como objetivo fornecer uma interface fácil de usar para gerenciar informações sobre os Pokémon em formato de cartão.


## Tecnologias Usadas

- **Java** 
- **Spring Boot**
- **Maven**

---

## ✨ Funcionalidades 

- **➕ **POST /api/pokemon**: Adiciona um novo Pokémon ao banco de dados.
- **🔍 **Busca de Pokémon**: **GET /api/pokemon/search**: Busca Pokémon por nome ou tipo. Parâmetros de busca podem ser passados via query string (`name`, `type`).
- **📜 *GET /api/pokemon/{id}**: Retorna um Pokémon específico pelo ID.
- **✏️ **PUT /api/pokemon/{id}**: Atualiza as informações de um Pokémon existente.
- **🗑️ **DELETE /api/pokemon/{id}**: Exclui um Pokémon do banco de dados.
 
---

## 📂 Estrutura do Projeto

```
📂 src/main/java/com/pokemon/api
├── PokemonApiApplication.java  # Classe principal da aplicação
├── PokemonController.java      # Controlador REST da API
└── Pokemon.java                # Modelo de dados para os mangás
```

---

## 🚀 Como Usar

1. Certifique-se de ter o **Java 17** e **Maven** instalados.
2. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/pokemon-api.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd manga-api
   ```
4. Execute o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Acesse a API em `http://localhost:8080/api/pokemon`.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

1. Fork o projeto.
2. Crie uma branch com sua feature:
   
bash
   git checkout -b minha-feature

3. Commit suas alterações:
   
bash
   git commit -m 'Minha nova feature'

4. Envie sua branch:
   
bash
   git push origin minha-feature

5. Abra um Pull Request.

---

## 🧑‍💻 Desenvolvedor

Feito com ❤️
