<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lister des Clients</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/Forms.css"/>" />
</head>
<body>
	<div class="container">
		<c:import url="/inc/menu.jsp"/>
		<div id="corps">
			<c:choose>
				<%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
				<c:when test="${ empty sessionScope.clients }">
					<p class="text-danger">Aucun Client Enregistré. </p>
				</c:when>
				<%-- Sinon, affichage du tableau. --%>
				<c:otherwise>
					<table>
						<tr>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Adresse</th>
							<th>Téléphone</th>
							<th>Email</th>
							<th class="action">Action</th>
						</tr>
						<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
						<c:forEach items="${ sessionScope.clients }" var="mapClients" varStatus="boucle">
						<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
						<tr class="${ boucle.index % 2 == 0 ? 'paire' : 'impair' }">
						<%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
							<td><c:out value="${ mapClients.value.nom }"/></td>
							<td><c:out value="${ mapClients.value.prenom }"/></td>
							<td><c:out value="${ mapClients.value.adresse }"/></td>
							<td><c:out value="${ mapClients.value.telephone }"/></td>
							<td><c:out value="${ mapClients.value.email }"/></td>
							<%-- Lien vers la servlet de suppression, avec passage du nom du client 
							- c'està-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
							<td class="action">
								<a href="<c:url value="/suppressionClient"><c:param name="nomClient" value="${ mapClients.key }"/></c:url>">
									<img alt="Supprimer" src="<c:url value="/inc/supprimer.png" />">
								</a>
							</td>
						</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>