create table curso(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    categoria varchar(50) not null,
    primary key(id)
);

insert into curso (id, nome, categoria) values (2, "Java JDK", "Programação");