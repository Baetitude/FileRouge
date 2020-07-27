<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Afficher Client</title>
	    <link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css"/>" />
	  	<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/Forms.css"/>" />
	</head>
	<body>
		<div class="container">
		 <c:import url="/inc/menu.jsp"/>
			<%-- Affichage de la chaîne "message" transmise par la servlet --%>
			<p class="info h1">${ message }</p>
			<%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
			<p class="h3">Client</p>
			<c:if test="${ !erreur }">
				<p>Nom : <c:out value="${ client.nom }" /> </p>
				<p>Prénom : <c:out value="${ client.prenom }" /></p>
				<p>Adresse : <c:out value="${ client.adresse }" /></p>
				<p>Numéro de téléphone : <c:out value="${ client.telephone }" /></p>
				<p>Email : <c:out value="${ client.email }" /></p>
			</c:if>
		</div>
	</body>
</html>