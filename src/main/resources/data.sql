
DROP table IF EXISTS empleado;

create table empleado(
	id int auto_increment,
	nombre varchar(250),
	trabajo varchar(250),
	salario double,
	dni integer
);

insert into empleado (nombre, trabajo, salario, dni) values ('DavidDubi','Gammer maincraf', 1500.0 ,123456789);
insert into empleado (nombre, trabajo, salario, dni) values ('Mednologic','Médico Programador',1300.1 ,122222222);
insert into empleado (nombre, trabajo, salario, dni) values ('OctavioGH','Jefe Amason', 15.0 ,123333333);
insert into empleado (nombre, trabajo, salario, dni) values ('Ash','Entrenador Pokemon', 2500.6 ,123444444);
insert into empleado (nombre, trabajo, salario, dni) values ('Mariana','Programadora', 850.99  ,123455555);