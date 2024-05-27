## Descrição

Tech Challenge da Fase 1 do curso Pós-Tech em Arquitetura de Software. Desenvolvimento de sistema de gerenciamento de pedidos para lanchonete em expansão.

## Infraestrutura

Para a construção da aplicação foram utilizadas as tecnologias:

- Java
- Spring Framework
- Banco de dados PostgreSQL
- Swagger para documentação das APIs

## Documentação do Sistema (DDD)

Para documenação dos fluxos foi criado um board na Miro onde foi desenhado o fluxo de negócio e disponibilizado o dicionário de linguagem ubiqua.

Miro: *COLOCAR O LINK DO MIRO OU TROCAR PELA IMAGEM*

## Inicialização da aplicação

Para iniciar a aplicação foi disponibilizado um aquivo **docker-compose.yml** com as configurações necessárias para execução, incluindo o build da aplição em uma imagem Docker e um container para o banco de dados PostgreSQL.

Para inicializar a aplicação, rode o comando:

Para Mac ou Linux:
```bash
export APP_ENV=prod
export POSTGRES_PASSWORD=root
export POSTGRES_USER=postgres
export POSTGRES_DB=tech
docker compose up -d
```

## Documentação das APIs

Para documentação das APIs utilizamos o framework Swagger. Após a inicialização da aplicação o mesmo fica disponível em [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/), onde é possível realizar requisições para os endpoints através do mesmo.

Na própria página do Swagger é disponibilizado exemplos de requests.

## Recursos REST disponibilizados

- Criação de Clientes
- Busca de Cliente por CPF
- CRUD de Produto
- Criação e gerenciamento de pedidos

### Fluxo das APIs para criação de pedido

Os passos para testar a API são os seguintes:

1. Criar produtos <br>
    Na propriedade 'categoria' preencha com uma das opções validas:<br>
    - LANCHE<br>
    - ACOMPANHAMENTO<br>
    - BEBIDA<br>
    - SOBREMESA<br>
1. Criar cliente (opcional)
1. Criar pedido (Cliente ID no payload é opcional)
1. Confirmar pedido (Durante a confirmação será feito um 'fake checkout' e o pedido irá direto para o status de 'RECEBIDO')

Após esses passos, o pedido irá pra linha de produção da cozinha. O mesmo estará disponivel no endpoint de pedidos das cozinhas. A etapa em que o pedido está poderá ser atualizada usando o endpoint de atualizar etapa. Ao mudar o status pra "recebido", o pedido não retornará mais no endpoint da linha de produção da cozinha. Nessa etapa, o status do pedido pode ser mudado para os seguintes:

- `RECEBIDO`: O pagamento foi confirmado e está pronto para ser produzido
- `EM_PREPARACAO`: O pedido está sendo preparado
- `PRONTO`: O pedido está pronto e o cliente pode busca-lo
- `FINALIZADO`: O pedido foi entregue ao cliente

Para testar as APIs, utilize o Swagger diretamente ou pelo cliente de sua preferencia.