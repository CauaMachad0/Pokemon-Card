Projeto: API de Cartas Pokémon

Descrição

Esta API permite gerenciar cartas Pokémon com funcionalidades de CRUD e busca. Desenvolvida em Java com o Spring Boot, é uma aplicação RESTful sólida e extensível.

Tecnologias Utilizadas

Linguagem: Java

Framework: Spring Boot

RESTful API

Gerenciamento de dependências: Maven

Funcionalidades Principais

CRUD de Pokémon:

GET /api/pokemon: Listar todos os Pokémon cadastrados.

GET /api/pokemon/{id}: Buscar um Pokémon específico pelo ID.

POST /api/pokemon: Adicionar um novo Pokémon.

PUT /api/pokemon/{id}: Atualizar as informações de um Pokémon existente.

DELETE /api/pokemon/{id}: Remover um Pokémon do banco de dados.

Busca Avançada:

GET /api/pokemon/search?name={name}&type={type}:

Filtrar Pokémon por nome e/ou tipo.

Exceções Personalizadas:

Tratamento para Pokémon inexistentes com mensagens claras.

Como Executar

Certifique-se de ter o Java JDK 11 ou superior instalado.

Clone ou baixe o repositório.

Compile e execute a aplicação:

mvn spring-boot:run

Acesse os endpoints usando uma ferramenta como Postman ou cURL.

Estrutura de Dados

Cada Pokémon contém os seguintes atributos:

ID: Identificador único gerado automaticamente.

Nome: Nome do Pokémon.

Tipo: Tipo principal do Pokémon (ex.: Fogo, Água, Planta).

Nível: Nível de experiência do Pokémon.

Possíveis Melhorias

Integração com um banco de dados (ex.: MySQL ou PostgreSQL).

Autenticação e autorização para operações sensíveis.

Expansão do modelo para incluir habilidades, ataques e evoluções dos Pokémon.

Implementar paginação e ordenação na listagem.


