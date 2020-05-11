<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title></title> 
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos.css">
	

</head>  
<body>
    <form action="ServletUser" method="post" class="formulario">
    
    <h1>Login</h1>
     <div class="contenedor">
     
     
         
         <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="text" name="usuario" placeholder="Usuario">
         
         </div>
         
         <div class="input-contenedor">
        <i class="fas fa-key icon"></i>
         <input type="password" name="contra" placeholder="Contraseña">
         
         </div>
         <input type="submit" value="Entrar" class="button">
         
         
         <p>¿No tienes una cuenta? <a class="link" href="index.jsp">Registrate </a></p>
     </div>
    </form>
    
    
</body>
</html>