# Estoque

Api para realizar cadastro de produtos e gerenciar um pequeno estoque, entrada e saída.

Essa API tem fins de estudo e de apresentar partes do meu conhecimento como desenvolvedor.

### Ref. name: *bvss-es6-api-estoque*.

- bvss: Abrevição da marca.
- es6: Sigla aleatória que será usada como referência para um grupo de aplicações que tem a mesma finalidade de uso ou grupo.
- api: Indica que essa aplicação é uma API.
- estoque: Informa que essa aplicação da sigla (es6) é relacionada ao serviço de negócio de estoque

### Config Server

Essa API consome dados do serviço de config server para ler as configuraçoes/propriedades a serem carregadas.

Ela não utiliza o application.yml, caso queira usar um arquivo local, veja configuraçoes na doc do spring e para executa-lá será
nessário subir também a aplicação [BVSS Config Server](https://github.com/brunovschettini/bvss-config-server/) localmente.