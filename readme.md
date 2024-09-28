# Assessment Domain-Driven Design (DDD) e Arquitetura de Softwares Escaláveis com Java

## Pré-requisitos

Antes de começar, você precisará ter instalado:
- [Rabbit](https://www.rabbitmq.com/docs/download)
- 
## Clonando o Projeto

Clone este repositório em sua máquina local:

```bash
git clone <URL-do-repositorio>
cd <nome-do-repositorio>
```

## Utilização no Postman

### Criar Usuário
***POST***
- http://localhost:8080/usuarios

````
{
    "nome":"nome",
    "email":"@gmail.com",
    "senha":"123"
}
````

### Criar Livros
***POST***
- http://localhost:8081/livros
```
{
    "titulo": "O Senhor dos Anéis",
    "autor": "J.R.R. Tolkien",
    "edicao": "Edição Especial",
    "usuarioId": 1
}
```

### Criar Empréstimo
***POST***
- http://localhost:8082/emprestimos/{ID_do_livro}
```
{
    "nomeUsuario":"nome",
    "dataEmprestimo":"27/09/2024",
    "dataDevolucao":"30/09/2024"

}
```



### Consulta Usuários
***GET***
- http://localhost:8080/usuarios

### Consulta Livros
***GET***
- http://localhost:8081/livros

### ~~Consulta Empréstimos~~
~~***GET***~~
- ~~http://localhost:8082/emprestimos~~

<sub>Devido as mudanças do Publisher e Listener do Rabbit o get parou de funcionar</sub>