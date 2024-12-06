Para iniciar o banco de dados já populado (necessário pra rodar o projeto receptor), basta executar o seguinte comando no cmd dentro da pasta mysql:

docker-compose -f docker-compose.mysql.yml up -d

Lembrando também que para ambos os projetos funcionarem é necessário ter rodando um container do RabbitMQ, e para que o Jenkins faça o build e o deploy, um container do SonarQube também.
