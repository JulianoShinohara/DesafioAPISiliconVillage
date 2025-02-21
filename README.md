
# Manual de Execução para o Projeto

---

## 1. Pré-requisitos

Antes de iniciar a execução do projeto, verifique se você tem os seguintes pré-requisitos:

- **Node.js**: Instalar a versão mais recente do Node.js (https://nodejs.org/).
- **Angular CLI 17**: Instalar o Angular CLI globalmente via npm:
  ```bash
  npm install -g @angular/cli@17
  ```
- **Java**: Instalar o JDK 17 ou superior para a execução do backend em Java.
- **Spring Boot**: Certifique-se de que o Spring Boot esteja configurado corretamente no backend.
- **Banco de Dados**: Ter um banco de dados configurado, MySQL.

---

## 2. Configuração do Backend

### 2.1. Clonando o Repositório do Backend

1. Clone o repositório do backend para sua máquina local:
   ```bash
   git clone https://github.com/JulianoShinohara/DesafioAPISiliconVillage.git
   ```

2. Navegue até o diretório do projeto.

### 2.2. Configurando o Banco de Dados

1. Verifique as configurações do banco de dados no arquivo `application.properties` ou `application.yml` (geralmente localizado em `src/main/resources`).

   Configurações típicas de banco de dados:
   ```properties
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost/siliconvillage?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=
   ```

2. Crie o banco de dados conforme especificado no arquivo de configurações.

### 2.3. Executando o Backend

1. Com o Spring Boot configurado, execute o servidor com o comando:
   ```bash
   ./mvnw spring-boot:run
   ```

2. O backend estará disponível em `http://localhost:8080`.

---

## 3. Configuração do Frontend

### 3.1. Clonando o Repositório do Frontend

1. Clone o repositório do frontend para sua máquina local:
   ```bash
   git clone https://github.com/JulianoShinohara/DesafioAPISiliconVillage.git
   ```

2. Navegue até o diretório do frontend:
   ```bash
   cd Frontend/desafiio_api
   ```

### 3.2. Instalando Dependências

1. Instale as dependências necessárias com o npm:
   ```bash
   npm install
   ```

### 3.3. Configurando as URLs de API

1. Certifique-se de que as URLs de API no código do frontend estejam apontando para o servidor correto. Verifique o arquivo de configuração onde as URLs de API estão sendo declaradas.

   Exemplo de configuração da URL no serviço de transações:
   ```typescript
   private apiUrl = 'http://localhost:8080/conta';
   ```

### 3.4. Executando o Frontend

1. Para iniciar o servidor de desenvolvimento do Angular, execute:
   ```bash
   ng serve
   ```

2. O frontend estará disponível em `http://localhost:4200`.

---

## 4. Testando o Projeto

### 4.1. Testando a API (Backend)

1. Use o Postman ou qualquer outro cliente HTTP para testar as rotas da API. Por exemplo:
   - **Buscar transações por CPF**:  
     `GET http://localhost:8080/transacoes/{cpf}`
   - **Buscar pessoas cadastradas**:  
     `GET http://localhost:8080/pessoas`

2. Envie uma requisição para as URLs mencionadas e veja a resposta.

### 4.2. Testando a Interface do Usuário (Frontend)

1. Abra `http://localhost:4200` no navegador.
2. Navegue até as páginas, como a de "Contas" e "Pessoas".
3. Teste os formulários de entrada de dados, como CPF e data, e verifique se a resposta do backend é exibida corretamente na interface.

---

## 5. Funcionalidades Disponíveis

### 5.1. Cadastro de Pessoas

- Na página de cadastro, você pode inserir informações sobre uma pessoa, como nome, CPF e data de nascimento.
- Após o preenchimento, os dados são enviados ao backend via uma requisição POST.

### 5.2. Listagem de Transações

- Na página de listagem de transações, você pode visualizar as transações feitas por uma pessoa, filtradas pelo CPF.
- Você também pode aplicar filtros por período (data inicial e final) para ver transações em um intervalo de tempo específico.

---

## 6. Estrutura do Projeto

### 6.1. Backend (Java - Spring Boot)

- **Controllers**: Manipula as requisições HTTP (ex. `PessoaController`, `TransacaoController`).
- **Services**: Contém a lógica de negócios (ex. `PessoaService`, `TransacaoService`).
- **Repositories**: Interage com o banco de dados (ex. `PessoaRepository`, `TransacaoRepository`).
- **Models**: Contém as classes que representam os dados (ex. `Pessoa`, `Transacao`).

### 6.2. Frontend (Angular)

- **Components**: Componentes responsáveis pela exibição de diferentes partes da interface (ex. `TransacoesComponent`, `CadastroPessoaComponent`).
- **Services**: Responsáveis por fazer as requisições HTTP para a API backend (ex. `TransacaoService`, `PessoaService`).
- **Models**: Contém as interfaces que representam os dados utilizados (ex. `Pessoa`, `Transacao`).

---

## 8. Conclusão

Este manual de execução orienta sobre como configurar e executar tanto o frontend quanto o backend do projeto. Após seguir as instruções, você será capaz de testar a comunicação entre os sistemas e garantir que todas as funcionalidades estejam operando conforme o esperado.
