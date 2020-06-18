<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benvenuto</title>
</head>
<body>
<div align="center">
	<h2>Gestionale della libreria/cartolibreria di BOB</h2>
<h3><a href="new">Nuovo Prodotto</a></h3>
	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Quantit�</th>
			<th>Categoria</th>
			<th>Azioni</th>
		</tr>
		<c:forEach items="${listaProdotti}" var="prodotto">
		<tr>
			<td>${prodotto.id}</td>
			<td>${prodotto.nome}</td>
			<td>${prodotto.quantita}</td>
			<td>${prodotto.categoria}</td>
			<td>
				<a href="edit?id=${prodotto.id}">Edita</a>
				&nbsp;&nbsp;&nbsp;
				<a href="delete?id=${prodotto.id}">Elimina</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>