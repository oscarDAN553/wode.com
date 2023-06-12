create table barcodes(
    id bigint not null auto_increment,
    id_producto bigint not null,
    barcode varchar(15) not null,
    activo varchar(1) not null,
    primary key(id),
    foreign key (id_producto) references productos(id)
);