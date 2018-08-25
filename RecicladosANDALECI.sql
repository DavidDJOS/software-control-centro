create database RecicladosANDALECI;
use RecicladosANDALECI;

create table materiales(
id_material int primary key auto_increment,
nombre varchar(100),
precio decimal(20)
);

create table compras(
id_compra int primary key auto_increment,
material varchar(100) ,
cantidad decimal(60),
precio decimal(10),
costo_pagado decimal(60),
fecha datetime

);

create table ventas(
id_venta int primary key auto_increment,
material varchar(100),
costo_vendido decimal(10),
fecha datetime,
costo_recivido decimal(10)
);

create table ingresos(

);