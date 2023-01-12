create table user(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into user values(0, 'Pessoa Teste', 'teste@teste.com');