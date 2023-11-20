# ms1-projarc

Microservice #1 for my software design and architecture class, it communicates with [this microservice](https://github.com/ShaihanBuenos/projArqT2M2) through a queue with RabbitMQ and FeignClient.


Comandos para rodar

Antes de tudo
docker network create minha_rede_comum

--Antes dar um clean e build
Cria imagem - docker build -t ms1:latest .

Roda imagem - docker compose up

Mata o container - docker compose down



URL RABBIT -- http://localhost:15672