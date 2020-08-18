<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Création d'une Commande</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css"/>" />
		<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/Forms.css"/>" />
	</head>
	<body>
		<div class="container">
		<c:import url="/inc/menu.jsp"/>
		<br>
		<div class="row">
				<div class="col-md-4">
					 <form method="post" action="<c:url value="/creationCommande"/>" enctype="multipart/form-data">
						 <fieldset>
							 <legend class="h4">Informations client</legend>
							 <%-- Si et seulement si la Map des clients en session n'est pas vide, alors on propose un choix à l'utilisateur --%>
							 <c:if test="${ !empty sessionScope.clients }">
							 	<label for="choixNouveauClient">Nouveau Client ? <span class="requis">*</span></label>
							 	<input type="radio" id="choixNouveauClient" name="choixNouveauClient" value="nouveauClient" checked /> Oui
							 	<input type="radio" id="choixNouveauClient" name="choixNouveauClient" value="ancienClient" /> Non <br>
							 </c:if>
							 
							 <c:set var="client" value="${ commande.client }" scope="request"/>
							 <div id="nouveauClient">
							 	<c:import url="/inc/inc_client_form.jsp"/>
							 </div>
							 
							 <%-- Si et seulement si la Map des clients en session n'est pas vide, alors on crée la liste déroulante --%>
							 <c:if test="${ !empty sessionScope.clients }">
							 	<div id="ancienClient">
							 		<select name="listeClients" id="listeClients">
							 			<option value="">Choisissez un client...</option>
							 			<%-- Boucle sur la map des clients --%>
							 			<c:forEach items="${ sessionScope.clients }" var="mapClients">
							 				<%-- L'expression EL ${mapClients.value} permet de cibler l'objet Client stocké 
							 				en tant que valeur dans la Map, et on cible ensuite simplement ses propriétés nom 
							 				et prenom comme on le ferait avec n'importe quel bean. --%>
							 				<option value="${ mapClients.value.nom }">${ mapClients.value.prenom }
							 				${ mapClients.value.nom }</option>
							 			</c:forEach>
							 		</select>
							 	</div>
							 </c:if>
					 	</fieldset>
					 	
						<fieldset>
						<legend class="h4">Informations commande</legend>
						
						<label for="dateCommande">Date <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />
						<span class="info">${ form.erreurs['dateCommande'] }</span>
						
						<label for="montantCommande">Montant <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20" />
						<span class="info">${ form.erreurs['montantCommande'] }</span>
						
						<label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="modePaiementCommande" name="modePaiementCommande" value="" size="20" maxlength="20" />
						<span class="info">${ form.erreurs['modePaiementCommande'] }</span>
						
						<label for="statutPaiementCommande">Statut du paiement</label>
						<input type="text" class="form-control form-control-sm" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="20" />
						<span class="info">${ form.erreurs['statutPaiementCommande'] }</span>
						
						<label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="20" maxlength="20" />
						<span class="info">${ form.erreurs['modeLivraisonCommande'] }</span>
						
						<label for="statutLivraisonCommande">Statut de la livraison</label>
						<input type="text" class="form-control form-control-sm" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="20" />
						<span class="info">${ form.erreurs['statutLivraisonCommande'] }</span>
						<br>
						
						<p class="info">${ form.resultat }</p>
						</fieldset>
						<input type="submit" class="btn btn-outline-primary btn-sm" value="     Valider     " />
						<input type="reset" class="btn btn-outline-danger btn-sm"   value="Remettre à zéro" /> <br />
					</form>
				</div>
			</div>
		</div><br>
		<script src="<c:url value="/inc/bootstrap-4.5.0-dist/js/jquery.js"/>"></script>
		<%-- Petite fonction jQuery permettant le remplacement de la première partie du formulaire par la liste déroulante, au clic sur le bouton radio. --%>
		<script>
			jQuery(document).ready(function(){
				/* 1 - Au lancement de la page, on cache le bloc d'éléments du formulaire
				correspondant aux clients existants */
			$("div#ancienClient").hide();
			/* 2 - Au clic sur un des deux boutons radio "choixNouveauClient", on affiche le
			bloc d'éléments correspondant (nouveau ou ancien client) */
			jQuery('input[name=choixNouveauClient]:radio').click(function(){
				$("div#nouveauClient").hide();
				$("div#ancienClient").hide();
				var divId = jQuery(this).val();
				$("div#"+divId).show();
			});
			});
		</script>
	</body>
</html>