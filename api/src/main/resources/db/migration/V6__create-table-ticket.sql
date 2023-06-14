create table tickets(
    id bigint not null auto_increment,
    fecha DATETIME not null ,
    total varchar(30) not null,
    listado_productos varchar(800) not null,
    activo varchar(1) not null,
    primary key(id)
);