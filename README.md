1. Crear proyecto Spring con Maven, para ello hay que ir a "New -- Spring Starter Project...".

![image](https://user-images.githubusercontent.com/103035621/168125588-33cfc683-0504-4838-a3fa-16451f942e9a.png)

A continuación, se rellenan los siguientes campos teniendo en cuenta la versión de java con la que se trabajará, el tipo de packaging en proyectos con api con despliegue en servidor de aplicaciones será del tipo war. Se define también un group y un artifact de estructura de proyecto, se prosigue pulsando next y proseguirá el siguiente menú de configuración.

![image](https://user-images.githubusercontent.com/103035621/168125697-2d56ce5e-7e94-47a8-8254-2294c715248d.png)

Una vez presionado el botón next, se deberán marcar las tecnologías a utilizar, en el caso de este ejemplo serán "Spring Boot Dev Tools", "Spring Data JPA", "H2 Database" y "Spring Web". Una vez marcados se pulsará finalizar y se creará la estructura de proyecto con Maven y Spring.

![image](https://user-images.githubusercontent.com/103035621/168125858-0da1207d-9077-47d0-bede-e84c74e8f16d.png)

2. Modificar el POM.xml, se ha de verificar que los elementos marcados durante la configuración de proyecto estén incluidos en el POM. En el siguiente cuadro está la base POM generada y necesaria.

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.7</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.crud.spring</groupId>
	<artifactId>Ejercicio_UD24</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>Ejercicio_UD24</name>
	<description>Ejercicio UD24</description>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

``` 

3. Crear paquetes de la estructura de proyecto. La estructura básica estará definida en 4 paquetes principales que almacenarán las diferentes clases e interfaces de proyecto:
	- PKG Controller.
	- PKG DAO.
	- PKG DTO.
	- PKG Service.

![image](https://user-images.githubusercontent.com/103035621/168126258-6ed8eb5b-7cd1-4cfb-b663-e1314e3a168d.png)

Se deberán crear tantas clases como sea necesario para desarrollar la aplicación deseada. Esta estructura es apta para api con una sola tabla. En esta estructura de proyecto se puede observar los paquetes creados, las clases creadas y las interfaces creadas.
También está el fichero POM de configuración de proyecto, el fichero application.propierties  que hace referencia al servidor de BBDD y el data.sql donde están las sentencias de BBDD, en este caso está el código de creación de una tabla con sus columnas y varios inserts en la BBDD para comprobar su correcto funcionamiento.

5. Editar el application.propierties.
	* Cambiar puerto mediante la sentencia "server.port= xxxx."
	* Habilitar consola h2 mediante la sentencia "spring.h2.console.enable=true".
	* Cambiar ruta de consola h2 mediante la sentencia "spring.h2.console.path="/database".

![image](https://user-images.githubusercontent.com/103035621/168126353-32670b29-2781-4c0f-994f-2a91dcef00aa.png)


6. A continuación se programará en la "dto_branch" el código referente a la clase "Empleado.Java". La clase Empleado del paquete DTO tiene la función de mapear el objeto a la tabla de la BBDD. Un objeto del tipo Empleado hará referencia a una "tupla" en la tabla Empleado. 
En esta clase se definen los atributos de clase que hacen referencia a las columnas de la tabla y se crean los diferentes constructores, en este caso 2, un constructor vacío y otro con todos los atributos de clase.
En la siguiente imagen se pueden observar los import a las diferentes utilizades y clases y los atributos de clase referentes a la tabla.

![image](https://user-images.githubusercontent.com/103035621/168126439-1438748b-60b9-4b56-93db-fa6affec146b.png)

En la siguiente imagen se pueden observar los constructores de clase, uno vacío y otro con todos los atributos de la clase.

![image](https://user-images.githubusercontent.com/103035621/168126500-e0621673-580b-4620-9c52-74ce31f9c879.png)

Y por último se pueden observar los Getters y Setters de los atributos de clase.

![image](https://user-images.githubusercontent.com/103035621/168126541-535b780d-2121-4528-be3d-b23d231b91e7.png)

7. Se prosigue programando en la "dao_branch" el código referente a la interfaz de "EmpleadoDAO". Esta clase hace referencia al Data Access Object, también denominado DAO. 

En esta interfaz se definen los métodos de acceso a datos de forma personalizada. En la siguiente imagen se puede ver una función que devuelve una lista de "Empleado" filtrando por nombre".

![image](https://user-images.githubusercontent.com/103035621/168126601-2907601d-08ce-4d9e-8e33-754317eff6b8.png)

8. A continuación se definirán los métodos en la interfaz "IEmpleadoService" en la rama "service_interface_branch". 
En esta interfaz se define la estructura de los métodos de acceso a datos CRUD, se crea una plantilla de los métodos para obligar a la clase que la herede tenga que implementar todas las instrucciones de la interfaz.

Se pueden observar 6 métodos:

	- Método listarEmpleados(): su función es generar una lista de Empleados.
	- Método guardarEmpleado(): su función es crear un empleado del tipo Empleado. Recibe 	como parámetro un empleado del tipo Empleado.
	- Método buscarEmpleadoId(): su función es buscar un empleado utilizando la ID como filtro. 	Recibe como parámetro un ID de tipo Long.
	- Método listarEmpleadoNombre(): su función es generar una lista de Empleados buscando 	por nombre. Recibe como parámetro un nombre de tipo String.
	- Método actualizarEmpleado(): su función es actualizar los registros de un empleado. Recibe 	como parámetro un empleado del tipo Empleado.
 
 ![image](https://user-images.githubusercontent.com/103035621/168126694-ede5c980-6a5e-4e33-a2ad-aefc2f222e72.png)

9. Lo siguiente será implementar los métodos de la interfaz en la clase "EmpleadoServiceImpl" en la rama "service_class_branch". 
Para realizar esto se deberá implementar la interfaz "IEmpleadoService" en la cabecera de la clase, una vez implementada aparecerá un warning indicando que se deben implementar los métodos de la interfaz. Se implementan todos los métodos y se rellena el cuerpo añadiendo las funcionalidades deseadas.

![image](https://user-images.githubusercontent.com/103035621/168126911-ee4a4bb4-7a9e-4791-b69e-70427aead409.png)

Una vez rellenado el cuerpo de los métodos implementados es recomendable escribir un comentario con una breve explicación de funcionamiento.
 
10. El siguiente paso será crear el controlador de Empleados, para ello se crea el package controller y la clase "EmpleadoController.Java". Lo correcto sería trabajar en la rama correspondiente, en este caso he trabajado en la misma rama. Primero de todo se crean las anotaciones @RestController y @RequestMapping("/api). La primera permite que los controladores Spring sean más cortos, permiten que una clase sea reconocida como un componente administrado por Spring y permitir el manejo de solicitudes HTTP usando API Rest.

La segunda anotación (@RequestMapping) permite mapear solicitudes HTTP con métodos de tal forma que se puedan ejecutar los métodos de los controladores MVC y Rest. 
En la siguiente imagen se pueden visualizar ambas anotaciones y la creación de la instancia de la clase "EmpleadoServiceImpl" para utilizar sus métodos a lo largo del controlador.

![image](https://user-images.githubusercontent.com/103035621/168127078-0fdc8496-1a16-47ff-ab91-2f0b939478b4.png)

A continuación, se mapean los siguientes métodos:

- Método listarEmpleados() con la ruta GET localhost:puerto/api/empleados.

![image](https://user-images.githubusercontent.com/103035621/168127132-e59094e1-9eca-4b0a-94d1-9b6f98fd62a6.png)

- Método listarEmpleadoNombre() con la ruta GET localhost:puerto/api/empleados/nombre/{nombre} donde {nombre} será el nombre a filtrar.

![image](https://user-images.githubusercontent.com/103035621/168127176-d625f97e-d4ed-4bfc-93c0-137f106c87b9.png)

- Método guardarEmpleado() con la ruta POST localhost:puerto/empleados se podrá introducir un empleado en el body de la petición y guardarlo en la base de datos.

![image](https://user-images.githubusercontent.com/103035621/168127241-2c74bd9e-85ab-4fa8-af04-d1d57036d573.png)

