create table remedio(
	
	id bigint not null auto_increment,
	nome varchar(100) not null,
	via varchar (100),
	lote varchar(100) not null,
	quantidade int,
	validade varchar(100) not null,
	laboratorio varchar (100),
	
	primary key (id)
	
);