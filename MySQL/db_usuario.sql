use db_pamcary_usuario;

drop table tb_usuario;

insert into tb_usuario(nome, cpf, data_nascimento, data) values ("João da Silva", "38545517842", "2018-12-28", current_timestamp);
insert into tb_usuario(nome, cpf, data_nascimento, data) values ("Fernando Cardoso", "12354469875", "1995-07-12", current_timestamp);
insert into tb_usuario(nome, cpf, data_nascimento, data) values ("Gustavo Santos", "54213325687", "2021-06-05", current_timestamp);
insert into tb_usuario(nome, cpf, data_nascimento, data) values ("Guilherme Bezerra", "53254463100", "2001-06-05", current_timestamp);
insert into tb_usuario(nome, cpf, data_nascimento, data) values ("Antonio Silveira", "45233365248", "1998-06-05", current_timestamp);

SELECT * FROM db_pamcary_usuario.tb_usuario;
