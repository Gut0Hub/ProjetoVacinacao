# ProjetoVacinacao
# Sistema de Vacinação

## Descrição

O Sistema de Vacinação é um projeto desenvolvido em Java com integração ao banco de dados MySQL, com o objetivo de armazenar e gerenciar informações relacionadas à vacinação da população.

O sistema permite cadastrar pacientes, cadastrar vacinas, registrar aplicações de vacinas e consultar os registros armazenados no banco de dados.

Este projeto foi desenvolvido como Projeto Integrador da disciplina de Banco de Dados e Estrutura de Dados do curso de Análise e Desenvolvimento de Sistemas.

---

## Objetivos

- Aplicar conceitos de Banco de Dados Relacional.
- Utilizar estruturas de dados em Java.
- Realizar integração entre Java e MySQL utilizando JDBC.
- Desenvolver uma interface de texto para interação com o usuário.
- Armazenar e consultar informações sobre vacinação da população.

---

## Tecnologias Utilizadas

- Java
- MySQL
- JDBC (MySQL Connector/J)
- Visual Studio Code
- Git
- GitHub

---

## Banco de Dados

Nome do banco:

```sql
sistema_vacinacao
```

### Tabela: paciente

Armazena informações dos pacientes cadastrados.

Campos:

- id
- nome
- idade
- endereco
- telefone
- regiao
- escolaridade
- teve_doenca

---

### Tabela: vacina

Armazena informações das vacinas.

Campos:

- id
- nome
- fabricante
- quantidade_doses

---

### Tabela: vacinacao

Armazena os registros de vacinação.

Campos:

- id
- paciente_id
- vacina_id
- data_aplicacao
- dose

Relacionamentos:

- paciente_id → paciente(id)
- vacina_id → vacina(id)

---

## Funcionalidades

### 1. Cadastro de Pacientes

Permite registrar:

- Nome
- Idade
- Endereço
- Telefone
- Região
- Escolaridade
- Histórico de doença

---

### 2. Listagem de Pacientes

Exibe todos os pacientes cadastrados no banco de dados.

---

### 3. Cadastro de Vacinas

Permite registrar:

- Nome da vacina
- Fabricante
- Quantidade de doses

---

### 4. Registro de Vacinação

Permite relacionar um paciente a uma vacina, registrando:

- Paciente
- Vacina
- Data de aplicação
- Dose aplicada

---

### 5. Listagem de Vacinações

Exibe todos os registros de vacinação armazenados no banco de dados.

---

## Estrutura do Menu

```text
===== SISTEMA DE VACINAÇÃO =====

1 - Cadastrar paciente
2 - Listar pacientes
3 - Cadastrar vacina
4 - Registrar vacinação
5 - Listar vacinações
0 - Sair
```

---

## Exemplos de Dados Cadastrados

### Paciente

```text
Nome: Augusto Monteiro Alves de Castro
Idade: 22
Endereço: Rua A13 Residencial Aquarela
Telefone: 62995452989
Região: GO
Escolaridade: Ensino Superior - Em andamento
Teve doença: false
```

### Vacina

```text
Nome: Covid-19
Fabricante: Pfizer
Quantidade de doses: 2
```

### Registro de Vacinação

```text
Paciente: Augusto Monteiro Alves de Castro
Vacina: Covid-19
Data: 2026-06-22
Dose: 1
```

---

## Estrutura de Dados Utilizada

O projeto utiliza estruturas de dados da linguagem Java para manipulação das informações durante a execução do programa.

Os dados são posteriormente persistidos no banco de dados MySQL através da API JDBC.

---

## Resultados Obtidos

O sistema foi capaz de:

- Cadastrar pacientes.
- Cadastrar vacinas.
- Registrar vacinações.
- Consultar pacientes cadastrados.
- Consultar vacinações realizadas.
- Armazenar todas as informações em banco de dados relacional.

---

## Equipe do Projeto

- Augusto Monteiro Alves de Castro
- João Victor Bianchini

Curso de Análise e Desenvolvimento de Sistemas (ADS)

Projeto Integrador desenvolvido para fins acadêmicos utilizando Java, MySQL e JDBC.
