# Back-End Spring Boot
Back-End Java Spring Boot (Microsserviço) do Reino antigo SRM como solução de conversão de moedas para atender o fluxo de negociações comerciais. 
Tecnologias Envolvidas:
- Implementado em Java Spring Boot
- Mensageria com RabbitMQ
- Banco de Dados Postgres
- Docker

## Subindo a Aplicação

Ação abaixo já sobe o BD também.
```docker
docker-compose up -d
docker restart srm_api
```
[Dump](dump.sql) do BD.

## Caso de Uso Fluxo Básico

Aqui você pode testar via Postman.

- Antes de tudo, vamos ver as moedas principais.
	```bash
        GET http://localhost:8080/moeda
	```
         
- Atualizando a principal Taxa de Cambio do condado Wefin: o Ouro Real e Tibar (item 1 do Desafio)
	1º) Veja como está o Cambio antes da Atualização de Mercado
	```bash 
        	GET http://localhost:8080/taxacambio
	```
	2º) Sim, agora vamos atualizar
	```bash 
        	PUT http://localhost:8080/taxacambio/1/2?novataxa=3
	```
	        
- Ajustando taxas de determinado produto (item 2.2 do Desafio)
	```bash
	PUT http://localhost:8080/produto/1?novataxa=3
	```
        
- Serviço de Conversão Resiliente onde utiliza o conceito de fila (RabbitMQ)
	Item 3 e 4.2 do desafio
	```bash
        POST http://localhost:8080/transacao/converter/fila?idProduto=1&idMoedaDestino=2&quantidade=300
	```
	Pegue o protocolo (por exemplo 582ac714-3ce9-4093-853d-18d14446ad49) para consultar a requisição na fila
	```bash
        GET http://localhost:8080/transacao/582ac714-3ce9-4093-853d-18d14446ad49
	```
        
- Voltando a consultar Taxa de Cambio (item 4.2 do desafio):
	```bash
        GET http://localhost:8080/taxacambio/1
	```

## Falta Implementar
- Estratégia de Conversão de Produtos (foi iniciado): uma estratégia que permita configurar fórmulas de conversão personalizadas para cada tipo de produto (item 2.1 do Desafio).
- Consultas Avançadas
- Teste Unitário

## Documentação

[Doc](http://localhost:8080/swagger-ui/index.html)

[Diagrama ER](diagrama_ER_SRM.png)

## Outros Acessos

Gerenciador do [RabbitMQ](http://localhost:15672/#/queues), Usuário e Senha: guest


## Contato

[Augusto Arraes](http://linktr.ee/a.arraes)
