create table usuario(
    id bigint not null,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario values(2, 'Amanda', 'amanda@gmail');