# NLW Connect Java 2025 🚀

Projeto desenvolvido durante a **NLW Connect Java 2025** promovida pela Rocketseat. A aplicação é uma API REST para gerenciamento de eventos com sistema de inscrições, indicações e ranking de usuários.

---

## 📌 Funcionalidades

- ✅ Criação de eventos
- ✅ Cadastro de usuários
- ✅ Inscrição de usuários em eventos
- ✅ Indicação de usuários (via link ou ID)
- ✅ Geração de ranking com base nas indicações por evento

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Docker**
- **Postman**

---

## 📂 Estrutura do Projeto

- `model/`: Entidades JPA
- `repository/`: Interfaces de persistência com Spring Data JPA
- `service/`: Regras de negócio da aplicação
- `controller/`: Endpoints da API
- `dto/`: Transferência de dados entre camadas

![image](https://github.com/user-attachments/assets/bed069d3-650d-4f72-9108-8ffc2ff78e0d)

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório**

    git clone https://github.com/Luiz1405/NLW-CONNECT-JAVA.git

2. **Configure o banco de dados**
   
   Crie um banco de dados MySQL chamado nlwconnect.
   Altere o arquivo src/main/resources/application.properties com as suas credenciais do MySQL.

   Exemplo para o arquivo aplication.properties:
   
   spring.datasource.url=jdbc:mysql://localhost:3306/nlwconnect
   
   spring.datasource.username=seu_usuario
   
   spring.datasource.password=sua_senha
   
   spring.jpa.hibernate.ddl-auto=update
   

4. **Execute o projeto**
   
   Execute a classe EventsApplication na sua IDE ou com:
   ./mvnw spring-boot:run
---
## 📄 Endpoints da API
### ➕ Criar novo evento
POST /events:

![image](https://github.com/user-attachments/assets/78d2590d-d5ba-4748-bde1-17d7fed32290)

### 📃 Listar eventos
GET /events:

![image](https://github.com/user-attachments/assets/27083cfb-326c-4d3e-9800-e9d83a97cfaa)

###🔍 Buscar evento por nome formatado
GET /events/{prettyName}:

![image](https://github.com/user-attachments/assets/81f809c3-6c66-4c1b-8f9d-af53cdd619f7)

### 📝 Inscrever usuário no evento
POST /subscription/{prettyName}:

![image](https://github.com/user-attachments/assets/5550e25d-762d-410f-911e-bacd62404994)

### 🔗 Inscrição com indicação
POST /subscription/{prettyName}/ranking/{userId}:

![image](https://github.com/user-attachments/assets/f7185476-a333-4997-8c05-8b1f4dfe7990)

### 🏆 Visualizar ranking de indicações do evento
GET /subscription/{prettyName}/ranking:

![image](https://github.com/user-attachments/assets/272bcda5-78e1-4de2-ab20-87416f799020)

### 👤 Visualizar ranking com destaque do usuário
GET /subscription/{prettyName}/ranking/{userId}:

![image](https://github.com/user-attachments/assets/b7269ca5-4c33-47bc-97ba-c3352e5219b0)




