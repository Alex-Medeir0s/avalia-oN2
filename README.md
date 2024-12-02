# Backend - Sistema de Gerenciamento de Tarefas

Este projeto é um sistema simples para gerenciamento de tarefas, desenvolvido com o Spring Boot e integrado ao PostgreSQL. O sistema permite a criação, listagem e atualização do status de tarefas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (versão 2.x)
- **PostgreSQL** (banco de dados)
- **Spring Data JPA** (para comunicação com o banco de dados)


## Funcionalidades

1. **Criar Tarefa**
   - Método: `POST /tarefas`
   - Corpo: JSON com as propriedades `titulo`, `descricao`, e opcionalmente `status` (caso não seja informado, o status será automaticamente configurado como "Pendente").
   
2. **Listar Tarefas**
   - Método: `GET /tarefas`
   - Retorna uma lista de todas as tarefas cadastradas.

3. **Atualizar Status da Tarefa**
   - Método: `PUT /tarefas/{id}`
   - Parâmetro: `id` da tarefa
   - Corpo: JSON com a propriedade `status` para atualizar o status da tarefa (exemplo: `"Em andamento"`, `"Concluída"`, etc.).
