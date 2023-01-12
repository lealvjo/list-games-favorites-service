create table games(
    id bigint not null auto_increment,
    game varchar(100) not null,
    platform varchar(100) not null,
    has_game int(1) not null,
    started int(1),
    finished  int(1),
    dlc varchar(20),
    user_id bigint not null,
    primary key(id),
    foreign key(user_id) references user(id)
);
