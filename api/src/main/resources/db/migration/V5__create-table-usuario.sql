create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(50) not null ,
    horario varchar(20) not null ,
    sucursal varchar(40) not null ,
    cargo varchar(40) not null ,
    activo varchar(1) not null,
    primary key(id)
);