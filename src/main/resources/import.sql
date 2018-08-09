insert into Time values (1, 'São Paulo Futebol Clube');
insert into Time values (2, 'Sociedade Esportiva Palmeiras');
insert into Time values (3, 'Santos Futebol Clube');
insert into Time values (4, 'Sport Club Corinthians Paulista');
insert into Time values (5, 'Associação Portuguesa de Desportos');

insert into Campanha(id, id_time, nome, vigencia_inicial, vigencia_final) values (1, 1, 'Campanha 1', '2018-05-01', '2018-05-31');
insert into Campanha(id, id_time, nome, vigencia_inicial, vigencia_final) values (2, 1, 'Campanha 2', '2018-06-01', '2018-06-30');
insert into Campanha(id, id_time, nome, vigencia_inicial, vigencia_final) values (3, 1, 'Campanha 3', '2018-07-01', '2018-07-31');
insert into Campanha(id, id_time, nome, vigencia_inicial, vigencia_final) values (4, 1, 'Campanha 4', '2018-08-01', '2018-08-31');

insert into Cliente(id, nome, email, id_time) values (1, 'João da Silva', 'joaodasilva@gmail.com', 1);
insert into Cliente(id, nome, email, id_time) values (2, 'Jose da Silva', 'josedasilva@gmail.com', 2);


