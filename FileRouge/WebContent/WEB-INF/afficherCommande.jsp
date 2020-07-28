<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Affichage Commande</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css"/>" />
		<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/Forms.css"/>" />
	</head>
	<body>
		<div class="container">
		<c:import url="/inc/menu.jsp"/>
			<%-- Affichage de la chaîne "message" transmise par la servlet --%>
				<p class="success h1">${ form.resultat }</p>
			<%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
			
			<p class="h3">Client </p>
			<%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une
	propriété du bean commande --%>
				<p>Nom : <c:out value="${ commande.client.nom }"/></p>
				<p>Prénom : <c:out value="${ commande.client.prenom }"/></p>
				<p>Adresse : <c:out value="${ commande.client.adresse }"/></p>
				<p>Numéro de téléphone : <c:out value="${ commande.client.telephone }"/></p>
				<p>Email : <c:out value="${ commande.client.email }"/></p>
			 
			<p class="h3">Commande </p>
				<p>Montant : <c:out value="${ commande.montant }"/> </p>
				<p>Date : <c:out value="${ commande.date }"/> </p>
				<p>Mode de Paiement : <c:out value="${ commande.modePaiement }"/> </p>
				<p>Statut du Paiement : <c:out value="${ commande.statutPaiement }"/> </p>
				<p>Mode de Livraison : <c:out value="${ commande.modeLivraison }"/> </p>
				<p>Statut de la Livraison : <c:out value="${ commande.statutLivraison }"/> </p>
		</div>
	</body>
</html>