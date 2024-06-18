# java-spring-ies301-crud_clientes

CRUD de clientes, operações com Clientes, Endereços e Cartões.

## Descrição do Projeto

**Objetivo:** Desenvolver uma aplicação Java que implementa operações CRUD (Criação, Leitura, Atualização e Remoção).

Este projeto foi desenvolvido como parte dos estudos em Java e Spring Boot e inclui funcionalidades de autenticação e autorização de usuários. <br>
Os requisitos desta aplicação foram baseados nos requisitos de uma atividade acadêmica para cadastro de clientes.

### Requisitos Funcionais

| Regra  | Nome                   | Descrição                                                                                                  |
|--------|------------------------|------------------------------------------------------------------------------------------------------------|
| RF0001 | Cadastro de cliente    | O sistema deve possibilitar o cadastro de clientes.                                                        |
| RF0002 | Alterar cliente        | O sistema deve possibilitar a alteração de dados cadastrais de clientes.                                   |
| RF0003 | Inativar cliente       | O sistema deve possibilitar que clientes sejam inativados.                                                 |
| RF0004 | Consulta de clientes   | O sistema deve possibilitar que clientes sejam consultados com base em um filtro definido pelo usuário.    |
| RF0005 | Cadastro de endereço   | O sistema deve possibilitar associar diversos endereços ao cadastro de um cliente.                         |
| RF0006 | Cadastro de cartão     | O sistema deve possibilitar associar diversos cartões de crédito ao cadastro de um cliente.                |
| RF0007 | Alteração de senha     | O sistema deve possibilitar alterar a senha sem que seja necessário alterar todos os dados cadastrais.     |

### Requisitos Não Funcionais

| Regra  | Nome                   | Descrição                                                                                                  |
|--------|------------------------|------------------------------------------------------------------------------------------------------------|
| RNF001 | Senha forte            | A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas e caracteres especiais. |
| RNF002 | Confirmar senha        | O usuário obrigatoriamente deve digitar duas vezes a mesma senha no momento do registro.                   |
| RNF003 | Senha criptografada    | A senha deve ser criptografada.                                                                            |
| RNF004 | Alterar endereço       | O sistema deve possibilitar alterar e adicionar endereços sem a necessidade de alterar os demais dados.    |
| RNF005 | Código de cliente      | Todo cliente cadastrado deve receber um código único no sistema.                                           |

### Regras de Negócio

| Regra  | Nome                   | Descrição                                                                                                  |
|--------|------------------------|------------------------------------------------------------------------------------------------------------|
| RN0001 | Cadastro de cliente    | Obrigatório o cadastro dos seguintes dados: Gênero, Nome, Data de Nascimento, CPF, Telefone (DDD + número), e-mail, senha, endereço residencial. |
| RN0002 | Composição de endereço | Tipo de residência, Tipo Logradouro, Logradouro, Número, Bairro, CEP, Cidade, Estado e País. Todos os campos são obrigatórios. Opcionalmente pode ser preenchido um campo de observações. |
| RN0003 | Composição de cartão   | Número do cartão, nome impresso no cartão, bandeira do cartão e código de segurança.                       |

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
  - **Spring Web**
  - **Spring Security**
- **JWT (JSON Web Token)**
- **Springdoc**
- **H2 Database** <br>
Utilizado para fins de desenvolvimento. Este projeto de estudo concentra-se no desenvolvimento de uma aplicação com Spring Boot.

## Requisitos
- **Java 21**

## Documentação
A documentação da API utiliza Springdoc com Swagger para fornecer uma interface interativa e está disponível no endpoint `/swagger-ui.html` após iniciar a aplicação.

Encontre mais informações sobre as bibliotecas utilizadas em: <br>
https://spring.io/, https://github.com/jwtk/jjwt e https://springdoc.org/

## Instalação e Uso
Siga os passos abaixo para rodar este projeto localmente:
1. Download / Clone do repositório:
   ```sh
   $ git clone https://github.com/patrick-tobias/java-spring-ies301-crud_clientes.git
   $ cd java-spring-ies301-crud_clientes
   ```

2. Compilar e empacotar a aplicação:
   ```sh
   mvn clean package
   ```

3. Executar a aplicação:
   ```sh
   java -jar target/java-spring-ies301-crud_clientes-0.0.1-SNAPSHOT.jar
   ```
   
A API estará disponível em `http://localhost:8080`.
