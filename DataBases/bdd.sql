drop table if exists pronosticos;
drop table if exists usuarios_app;
drop table if exists partidos;
drop table if exists equipos_participantes;

create table equipos_participantes (
    codigo char(3) not null,
    nombre varchar(25) not null,
    constraint equipos_participantes_pk primary key (codigo)
);

create table partidos (
    codigo serial not null,
    encuentro varchar(50) not null,
    fecha date not null,
    hora time not null,
    constraint partidos_pk primary key (codigo)
);

create table usuarios_app (
    codigo serial not null,
    cedula char(10) not null,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
	constraint usuario_PK primary key(codigo),
    constraint usuarios_app_cedula_unique unique (cedula)
);

create table pronosticos (
    codigo_pronostico serial not null,
    codigo_usuario int not null,
    codigo_partido int not null,
    codigo_equipo_1 char(3) not null,
    marcador_asignado_e1 int not null,
    codigo_equipo_2 char(3) not null,
    marcador_asignado_e2 int not null,
    constraint pronosticos_pk primary key (codigo_pronostico),
    constraint usuario_fk foreign key (codigo_usuario) references usuarios_app (codigo),
    constraint partido_fk foreign key (codigo_partido) references partidos (codigo),
    constraint equipo_1_fk foreign key (codigo_equipo_1) references equipos_participantes (codigo),
    constraint equipo_2_fk foreign key (codigo_equipo_2) references equipos_participantes (codigo)
);

insert into equipos_participantes (codigo, nombre) 
values 
    ('032', 'Argentina'),
    ('068', 'Bolivia'),
    ('076', 'Brasil'),
    ('124', 'Canadá'),
    ('152', 'Chile'),
    ('170', 'Colombia'),
    ('188', 'Costa Rica'),
    ('218', 'Ecuador'),
    ('840', 'Estados Unidos'),
    ('388', 'Jamaica'),
    ('484', 'México'),
    ('591', 'Panamá'),
    ('600', 'Paraguay'),
    ('604', 'Perú'),
    ('858', 'Uruguay'),
    ('862', 'Venezuela');

insert into partidos (encuentro, fecha, hora) 
values 
    ('Argentina vs Canadá', '2024-06-20', '20:00'),
    ('Perú vs Chile', '2024-06-21', '19:00'),
    ('Ecuador vs Venezuela', '2024-06-22', '15:00'),
    ('México vs Jamaica', '2024-06-22', '20:00'),
    ('Estados Unidos vs Bolivia', '2024-06-23', '17:00'),
    ('Uruguay vs Panamá', '2024-06-23', '21:00'),
    ('Colombia vs Paraguay', '2024-06-24', '17:00'),
    ('Brasil vs Costa Rica', '2024-06-24', '18:00'),
    ('Chile vs Argentina', '2024-06-25', '21:00'),
    ('Perú vs Canadá', '2024-06-25', '17:00');

insert into usuarios_app (cedula, nombre, apellido) 
values
    ('0724681012', 'Jefferson', 'Pérez'),
    ('0703691215', 'Richard', 'Carapáz'),
    ('0748121618', 'Marlon', 'Vera');

insert into pronosticos (codigo_usuario, codigo_partido, codigo_equipo_1, marcador_asignado_e1, codigo_equipo_2, marcador_asignado_e2) 
values
    (1, 1, '032', 3, '124', 1),
    (1, 3, '218', 1, '862', 1),
    (1, 7, '170', 1, '600', 0),
    (2, 3, '218', 2, '862', 0),
    (2, 6, '858', 4, '591', 2),
    (2, 10, '604', 0, '124', 1),
    (3, 8, '076', 3, '188', 0),
    (3, 4, '484', 2, '388', 2),
    (3, 3, '218', 0, '862', 0);


select * from partidos where fecha between '2024-06-01' and '2024-06-30';

select * from usuarios_app where codigo = 1;

select * from partidos where encuentro = 'Ecuador vs Venezuela';

select * from pronosticos where codigo_usuario = 3;
select * from usuarios_app;

select * from equipos_participantes;
select * from partidos;
select * from usuarios_app;
select * from pronosticos;
