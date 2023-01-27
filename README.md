<h1><b>EVALUACIÓN PROGRAMADOR JAVA<b></h1>

<h2>Tema:Desarrollar una aplicación en Java utilizando spring-boot cumpliendo las siguientes condiciones:</h2>
•	Generar el objeto DAO para la siguiente estructura de tabla: <br> 
 <b>Empresa</b>
  (idEmpresa,
  ruc,
  RazonSocial,
  direccion,
  estado)<br> 

 La definición del tipo de dato y obligatoriedad de los campos queda a libertad del postulante.<br><br> 
•	Realizar un servicio rest que permita registrar los datos de la empresa (utilizar los atributos del objeto empresa). Utilizar para el registro la base de datos H2 o alguna implementación como Map o Collection para almacenar los datos en memoria.
Servicio: POST <br>
Ruta: http://localhost:8080/api/empresa/create<br>
Body: {
    "ruc":"123456789134",
    "razonSocial":"MARIA SAC",
    "direccion":"Jr avenida calle nro 123",
    "estado":true
}<br>

•	Realizar un servicio rest que devuelva una lista con los 3 últimos registros de empresas.<br>
Servicio: GET<br>
Ruta: http://localhost:8080/api/empresa/findLastThree<br>
Authorization : Basic Auth => User: hector , Password : 1234<br>

•	Segurizar los servicios rest anteriores utilizando spring-security <br>
Se realizó la seguridad en WebSecurityConfig.java

