# To Do List App

### Do que se trata?
Este é um projeto inspirado em algumas ferramentas 
de organização, como o Notion. Uma API de tarefas que 
são associadas a usuarios.

### Tecnologias usadas:
- <a href="https://www.java.com" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="30" height="30"/> </a> Java
- <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="30" height="30"/> </a> MySQL
- <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="30" height="30"/> </a> Postman
- <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="30" height="30"/> </a> Spring
- <a href="https://hibernate.org/" target="_blank" rel="noreferrer"> <img src="https://cdn.freebiesupply.com/logos/thumbs/2x/hibernate-logo.png" alt="hibernate" width="30" height="30"/> </a> Hibernate

### Requisitos do Projeto:
- JDK 17+
- MySQL
- Maven

### Como executar o Projeto?
Para a execução do projeto, basta dar um git pull neste repositorio e caso já tenha o [maven](https://phoenixnap.com/kb/install-maven-windows) instalado na sua maquina, abra o terminal no diretorio do projeto e digite os seguintes comandos: <br><br>

``mvn clean install `` <br> <br>
Assim o maven baixará todas as dependencias do projeto para o build.

``mvn spring-boot:run `` <br><br>
Assim o projeto subira localmente na porta 8080 (padrão).

### Utilizando o App:
A API possui alguns endpoints que podem:
- Salvar um usuario.
- Retornar todos os usuarios salvos.
- Retornar um usuario por ID.
- Deletar um usuario.
- Retornar uma tarefa por ID.

A rota de cadastro `@PostMapping("/users")` recebe como parametro um ``@RequestBody``, ou um Json que será mapeado para um objeto do tipo Usuario, por exemplo: <br>
``` json
    {
    "user": {
        "name": "Gustavo Lobo",
        "email": "g.lobo@email.com",
        "tasklist": [
               {
                 "title": "Improve API security development.",
                 "description": "Create a basic or JWT authentication feature for the project."
               },
               {
                 "title": "Finish the task routes development.",
                 "description": "Create new routes for POST, UPDATE and DELETE tasks."
               }
        ] 
    }
}
```

<bR>

A rota `@GetMapping("/users")` retornará todos os Usuarios cadastrados, bem como suas tarefas. <br>

A rota `@GetMapping("/users/{id}")` recebe um parametro do tipo `@PathVariable` que nesse caso é um Long ID, representando o ID do Usuario. <br>

A rota `@DeleteMapping("/users/{id}")` assim como a rota acima também recebe um parametro do tipo `@PathVariable`, porém nesse caso para fazer a exclusão do Usuario. <br>

E por fim a rota `@GetMapping("/tasks/{id}")` receberá um `@PathVariable` que será um Long id da tarefa, nesse caso retornará a Tarefa associada a esse ID.