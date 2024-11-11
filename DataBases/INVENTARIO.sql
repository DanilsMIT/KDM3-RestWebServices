drop table if exists DetallesVentas;
drop table if exists CabeceraVentas;
drop table if exists HistorialStock;
drop table if exists DetallesPedidos;
drop table if exists CabeceraPedidos;
drop table if exists EstadosPedido;
drop table if exists Proveedores;
drop table if exists TipoIdentificacion;
drop table if exists Productos;
drop table if exists UnidadesMedida;
drop table if exists CategoriaUnidadMedida;
drop table if exists Categorias;

-------------------- TABLAS --------------------
create table Categorias(
	CodeCat serial not null,
	nombre varchar(100) not null,
	CategoriaPadre int,
	constraint categoriasPk primary key (CodeCat),
	constraint categoriasFk foreign key (CategoriaPadre) references Categorias(CodeCat)
);

create table CategoriaUnidadMedida(
	CodeCUDM char(1) not null,
	nombre varchar(50) not null,
	constraint CategoriaUnidadMedidaPK primary key (CodeCUDM)
);

create table UnidadesMedida(
	CodeUDM varchar(2) not null,
	descripcion varchar(50) not null,
	Code_CUDM char(1) not null,
	constraint UnidadesMedidaPK primary key (CodeUDM),
	constraint CUDMFK foreign key (Code_CUDM) references CategoriaUnidadMedida(CodeCUDM)
);

create table Productos(
	CodeProducto serial not null,
	nombre varchar(100) not null,
	Code_UDM varchar(2) not null,
	Precio_Venta money not null,
	IVA boolean not null, 
	costo money not null,
	Code_Cat int not null,
	stock int not null,
	constraint ProductosPK primary key (CodeProducto),
	constraint UDMFK foreign key (Code_UDM) references UnidadesMedida(CodeUDM),
	constraint CategoriaFK foreign key (Code_Cat) references Categorias(CodeCat)
);

create table TipoIdentificacion(
	CodeI char(1) not null,
	descripcion varchar(20),
	constraint TipoIdentificacionPK primary key (CodeI)
);

create table Proveedores(
	Identificador varchar(13) not null,
	TipoDocumento char(1) not null,
	nombre varchar(50) not null,
	telefono char(10) not null,
	correo varchar(50) not null,
	direccion varchar(100) not null,
	constraint ProveedoresPK primary key (Identificador),
	constraint TipoDocumentoFK foreign key (TipoDocumento) references TipoIdentificacion(CodeI)
);

create table EstadosPedido(
	CodeEstado char(1) not null,
	descripcion varchar(20) not null,
	constraint EstadosPedidoPK primary key (CodeEstado)
);

create table CabeceraPedidos(
	CodeCabP serial not null,
	CodeProveedor varchar(13) not null,
	fecha date not null,
	estado char(1) not null,
	constraint CabeceraPedidosPK primary key (CodeCabP),
	constraint ProveedorFK foreign key (CodeProveedor) references Proveedores(Identificador)
);

create table DetallesPedidos(
	CodeDetPedido serial not null,
	Code_CabP int not null,
	Code_Producto int not null,
	cantidad int not null,
	subtotal money not null,
	cantidadRecibida int  not null,
	constraint DetallesPedidosPK primary key (CodeDetPedido),
	constraint CabeceraPedidosFK foreign key (Code_CabP) references CabeceraPedidos(CodeCabP),
	constraint ProductosPedidosFK foreign key (Code_Producto) references Productos(CodeProducto)

);

create table HistorialStock(
	codigo serial not null,
	fecha timestamp without time zone not null,
	referencia varchar(20) not null,
	Code_Producto int not null,
	cantidad int not null,
	constraint HistorialStockPK primary key(codigo),
	constraint ProductosFK foreign key(Code_Producto) references Productos(CodeProducto) 
);

create table CabeceraVentas(
	CodeCabV serial not null,
	fecha timestamp without time zone not null,
	total_sin_iva money not null,
	iva money not null,
	total money not null,
	constraint CabeceraVentasPK primary key (CodeCabV)
);

create table DetallesVentas(
	CodeDetVentas serial not null,
	Code_CabV int not null,
	Code_Producto int not null,
	cantidad int not null,
	precio_venta money not null,
	subtotal money not null,
	subtotal_con_iva money not null,
	constraint DetallesVentasPK primary key (CodeDetVentas),
	constraint CabeceraVentasFK foreign key (Code_CabV) references CabeceraVentas(CodeCabV),
	constraint ProductosVentasFK foreign key (Code_Producto) references Productos(CodeProducto)
);
-------------------- Inserciones --------------------
INSERT INTO Categorias (nombre, CategoriaPadre) 
values ('Materia Prima', null), ('Proteina', 1), ('Salsas', 1), ('Punto de Venta', null), ('Bebidas', 4), ('Con alcohol', 5), ('Sin alcohol', 5);

INSERT INTO CategoriaUnidadMedida (CodeCUDM, nombre) 
values ('U', 'Unidades'), ('V', 'Volumen'), ('P', 'Peso');

INSERT INTO UnidadesMedida (CodeUDM, descripcion, Code_CUDM) 
values ('ml', 'mililitros', 'V'), ('l', 'litros', 'V'), ('u', 'unidad', 'U'), ('d', 'docena', 'U'), ('g', 'gramos', 'P'), ('kg', 'kilogramos', 'P'), ('lb', 'libras', 'P');

INSERT INTO Productos (nombre, Code_UDM, Precio_Venta, IVA, costo, Code_Cat, stock) 
values ('Coca cola pequeña', 'u', 0.5804, true, 0.3729, 7, 110), ('Salsa de tomate', 'kg', 0.95, true, 0.8736, 3, 0), ('Mostaza', 'kg', 0.95, true, 0.89, 3, 0), ('Fuze Tea', 'u', 0.8, true, 0.7, 7, 50);

INSERT INTO TipoIdentificacion (CodeI,descripcion) 
values ('C', 'Cedula'), ('R', 'RUC');

INSERT INTO Proveedores (Identificador, TipoDocumento, nombre, telefono, correo, direccion) 
values ('1792285747', 'C', 'Santiago Mosquera', '0992920306', 'zantycb89@gmail.com', 'Cumbayork'), ('1792285747001', 'R', 'Snacks SA', '0992920398', 'snacks@gmail.com', 'La Tola');

INSERT INTO EstadosPedido (CodeEstado, descripcion) 
values('S', 'Solicitado'), ('R', 'Recibido');

INSERT INTO CabeceraPedidos (CodeProveedor, fecha, estado) 
values('1792285747', '30/11/2023', 'R'), ('1792285747', '01/12/2023', 'R');

INSERT INTO DetallesPedidos (Code_CabP, Code_Producto, cantidad, subtotal, cantidadRecibida) 
values (1,1,100,37.29,100), (1,4,50,11.8,50), (2,1,10,3.73,0);

INSERT INTO HistorialStock (fecha, referencia, Code_Producto, cantidad) 
values ('20/11/2023 19:59', 'Pedido 1', 1, 100), ('21/11/2023 19:59', 'Pedido 1', 4, 50), ('22/11/2023 20:00', 'Pedido 2', 1, 10), ('23/11/2023 20:00', 'Venta 1', 1, -5), ('24/11/2023 20:00', 'Venta 2', 4, 1);

INSERT INTO CabeceraVentas (fecha, total_sin_iva, iva, total) 
values ('20/11/2023 20:00', 3.26, 0.39, 3.65);

INSERT INTO DetallesVentas (Code_CabV, Code_Producto, cantidad, precio_venta, subtotal, subtotal_con_iva) 
values (1, 1, 5, 0.58, 2.9, 3.25), (1, 4, 1, 0.36, 0.36, 0.4);
-------------------- Selects --------------------
SELECT * FROM Categorias;
SELECT * FROM CategoriaUnidadMedida;
SELECT * FROM UnidadesMedida;
SELECT * FROM Productos;
SELECT * FROM TipoIdentificacion;
SELECT * FROM Proveedores;
SELECT * FROM EstadosPedido;
SELECT * FROM CabeceraPedidos;
SELECT * FROM DetallesPedidos;
SELECT * FROM HistorialStock;
SELECT * FROM CabeceraVentas;
SELECT * FROM DetallesVentas;