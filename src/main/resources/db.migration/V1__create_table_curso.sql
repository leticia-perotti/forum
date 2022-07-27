create table curso(
    id bigint not null,
    nome varchar(50),
    categoria varchar(50),
    primary key(id)
);

insert into curso (id, nome, categoria) values (2, "Java JDK", "Programação");