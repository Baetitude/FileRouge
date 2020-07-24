<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Afficher Client</title>
	    <link type="text/css" rel="stylesheet" href="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css" />
	  	<link type="text/css" rel="stylesheet" href="inc/bootstrap-4.5.0-dist/css/Forms.css" />
	</head>
	<body>
		<div class="container">
			<%-- Affichage de la chaîne "message" transmise par la servlet --%>
			<p class="info h1">${ message }</p>
			<%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
			<p class="h3"></p>
			<p>Nom : ${ client.nom }</p>
			<p>Prénom : ${ client.prenom }</p>
			<p>Adresse : ${ client.adresse }</p>
			<p>Numéro de téléphone : ${ client.telephone }</p>
			<p>Email : ${ client.email }</p>
		</div>
	</body>
</html>