# Sistema de Estoque (Java)

## Descrição

Aplicação de terminal para gerenciamento de produtos em estoque.
Permite operações básicas de CRUD com persistência de dados em JSON.

## Funcionalidades
Adicionar produto
Listar produtos
Buscar produto por ID
Atualizar produto
Remover produto

## Tecnologias
Java
Gson

## Como executar
Compile o projeto:
javac -cp "lib/*" -d bin src/app/Main.java
Execute:
java -cp "bin:lib/*" app.Main

## Observações
Os IDs são gerados automaticamente
Os dados são armazenados em produtos.json
