<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	
		<fieldset>
		
		<legend>Formulaire de connection</legend>
		
		<form action="authentification" method="post">
		
		<table>
		
		<tr>
			<td>Identifiant</td>
			<td><input type="text" name="pIdentifiant"></td>
		</tr>
		
		<tr>
			<td>Mot de passe</td>
			<td><input type="password" name="pMdp"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Se connecter"></td>
		</tr>
		
		</table>
		
		</form>
		
		</fieldset>
	
	</div>
</body>
</html>