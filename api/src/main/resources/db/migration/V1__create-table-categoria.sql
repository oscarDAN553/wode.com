create table categorias(
    id bigint not null auto_increment,
    nombre varchar(20) not null UNIQUE,
    activo varchar(1) not null,
    primary key(id)
);