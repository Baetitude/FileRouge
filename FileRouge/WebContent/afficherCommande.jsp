<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Affichage Commande</title>
		<link type="text/css" rel="stylesheet" href="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="inc/bootstrap-4.5.0-dist/css/Forms.css" />
	</head>
	<body>
		<div class="container">
			<%-- Affichage de la chaîne "message" transmise par la servlet --%>
				<p class="info h1">${ message }</p>
			<%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
			
			<p class="h3">Client </p>
			<%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une
	propriété du bean commande --%>
			<p>Nom : ${ commande.client.nom }</p>
			<p>Prénom : ${ commande.client.prenom }</p>
			<p>Adresse : ${ commande.client.adresse }</p>
			<p>Numéro de téléphone : ${ commande.client.telephone }</p>
			<p>Email : ${ commande.client.email }</p>
			 
			<p class="h3">Commande </p>
			<p>Montant : ${ commande.montant } </p>
			<p>Date : ${ commande.date } </p>
			<p>Mode de Paiement : ${ commande.modePaiement } </p>
			<p>Statut du Paiement : ${ commande.statutPaiement } </p>
			<p>Mode de Livraison : ${ commande.modeLivraison } </p>
			<p>Statut de la Livraison : ${ commande.statutLivraison } </p>
		</div>
	</body>
</html>