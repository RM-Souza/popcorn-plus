# Projeto Popcorn+

###Documentação

Neste deseafio - proporcionado pela Let's Code
em parceria com o Itaú - foi propost consumir
uma API pública de filmes salvando no banco de dados
avaliações, comentários e suas respostas.

####Lista de tecnologias usadas:
- Intellij IDEA
- Java 17
- Spring Boot 2.7.1
- Lombok
- PostgresSQL
- Insomnia (envio de requisições)

###Passo 1: Clone o projeto abaixo

```bash
git clone git@github.com:RM-Souza/popcorn-plus.git
```

###Passo 2: Abra o projeto

Há dois ambientes: test e dev. No ambiente "test" os
dados são salvos no H2; já no ambiente de dev, persistidos
no PostgresSQL.

É necessário criar um base de dados no <i>psql</i>
antes de subir a aplicação no ambiente de "dev".

Para tal, abra o seu terminal e conecte na instância
local do postgres e faça o seguinte comando:

```bash
create database popcornpludb;
```

Para alterar o ambiente basta ir em <i>application.yaml</i> e
alterar o valor da chave para "test" ou "dev", conforme
sua preferência.

###Requisições GET
####Filmes:
```bash
localhost:8080/movies
```
Resposta:

```bash
[
	{
		"id": 1,
		"title": "Star Wars - Episode IV",
		"year": 1977,
		"comments": 2,
		"MovieScore": 4.5
	},
	{
		"id": 2,
		"title": "Star Wars - Episode IX",
		"year": 2019,
		"comments": 1,
		"MovieScore": 2.0
	}
	...
]
```

O campo "MovieScore" é calculado através da média
aritmética do campo MyStarScore, dados pelo comentário
de cada usuário.

####Comentários

```bash
localhost:8080/comments
```
Resposta:

```bash
[
	{
		"Id": 1,
		"Description": "Great Movie! I miss Leia so much :(",
		"ThumbsUp": 2,
		"ThumbsDown": 1,
		"MyStarScore": 5,
		"User": {
			"Id": 1,
			"Nickname": "r2d2",
			"Email": "r2d2@gmail.com",
			"Ranking": "READER",
			"Score": 0
		}
	}
	...
]
```

###Usuários

```bash
localhost:8080/users
```

Resposta:

```bash
[
	{
		"Id": 1,
		"Nickname": "r2d2",
		"Email": "r2d2@gmail.com",
		"Ranking": "READER",
		"Score": 0
	},
	{
		"Id": 2,
		"Nickname": "bb8",
		"Email": "bb8@gmail.com",
		"Ranking": "READER",
		"Score": 0
	}
	...
]
```

###Requisição POST

Para inserir um usuário novo na base de dados, basta
enviar, apenas o Nickname e o Email. O Ranking, Score
e ID são setados de forma automática:

```bash
localhost:8080/users
```
Corpo:
```bash
{
		"Nickname": "XLR8",
		"Email": "XLR8@gmail.com"
}
```

Resultado:
```bash
{
	"Id": 5,
	"Nickname": "XLR8",
	"Email": "XLR8@gmail.com",
	"Ranking": "READER",
	"Score": 0
}
```

###Requisição DELETE:

```bash
localhost:8080/user/{id}
```

Não corpo na resposta para essa requisição, apenas retornado
o codigo 204.

###Considerações:

Pela complexidade do assunto e por não ter perícia 
no uso de APIs, o sistema se encontra incompleto. Foi uma oportunidade
de aprendizado bastante rica e motivante. Sou grato por ter chego até a
presente etapa. Aceitarei <b>TODO</b> feedback dado e pretendo continuar
atualizando o repositório mesmo após o término do desafio.

###Obrigado!