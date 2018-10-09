CREATE SCHEMA prova
  AUTHORIZATION postgres;

CREATE TABLE prova.usuario
(
  id serial NOT NULL,
  nome character varying(100) NOT NULL,
  usuario character varying(50) NOT NULL,
  senha character varying(50) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_usuario_key UNIQUE (usuario)
);

insert into prova.usuario(nome, usuario, senha)
	values ('Administrador', 'admin', '123');
	
create table prova.categoria(
	id serial primary key not null,
	descricao varchar(200) not null
)

create table prova.autor(
id serial primary key not null,
nome varchar(100)not null,
pseudonimo varchar(100) not null
)

create table prova.livro(
id serial primary key not null,
titulo varchar(100) not null,
datapublicacao timestamp not null,
id_categoria integer,
id_autor integer
)
alter table prova.livro add constraint fk_categoria foreign key (id_categoria) references prova.categoria(id);
alter table prova.livro add constraint fk_autor foreign key (id_autor) references prova.autor(id);

insert into prova.categoria (descricao) values ('Romance') 
insert into prova.categoria (descricao) values ('Drama') 
insert into prova.categoria (descricao) values ('Acao') 

insert into prova.autor (nome, pseudonimo) values ('Ana Maria','flor')
insert into prova.autor (nome, pseudonimo) values ('Carlos Silva', 'carlao')
