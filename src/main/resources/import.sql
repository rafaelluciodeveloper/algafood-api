insert into tab_cozinhas (id, nome) values (1, 'Tailandesa');
insert into tab_cozinhas (id, nome) values (2, 'Indiana');

insert into tab_estados (id, nome) values (1, 'Minas Gerais');
insert into tab_estados (id, nome) values (2, 'São Paulo');
insert into tab_estados (id, nome) values (3, 'Ceará');

insert into tab_cidades (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into tab_cidades (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into tab_cidades (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into tab_cidades (id, nome, estado_id) values (4, 'Campinas', 2);
insert into tab_cidades (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into tab_restaurantes (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into tab_restaurantes (id, nome, taxa_frete, cozinha_id) values (2, 'Thai Delivery', 9.50, 1);
insert into tab_restaurantes (id, nome, taxa_frete, cozinha_id) values (3, 'Tuk Tuk Comida Indiana', 15, 2);

insert into tab_formas_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into tab_formas_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into tab_formas_pagamento (id, descricao) values (3, 'Dinheiro');

insert into tab_permissoes (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tab_permissoes (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);
