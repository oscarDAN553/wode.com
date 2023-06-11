create table productos(

    id bigint not null auto_increment,
    marca varchar(20) not null,
    descripcion varchar(50) not null,
    contenido varchar(10) not null,
    precio_compra varchar(10) not null,
    precio_venta varchar(10) not null,
    cantidad varchar(100) not null,
    fecha_caducidad varchar(10) not null,
    ubicacion varchar(20) not null,
    categoria varchar(20) not null,
    actualizar varchar(1) not null,
    activo varchar(1) not null,
    primary key(id),
    foreign key (categoria) references categorias(nombre)
);