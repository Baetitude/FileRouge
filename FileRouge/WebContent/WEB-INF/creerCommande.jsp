<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Création d'une Commande</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css"/>" />
	</head>
	<body>
		<div class="container">
		<c:import url="/inc/menu.jsp"/>
		<br>
		<div class="row">
				<div class="col-md-4">
					 <form method="get" action="<c:url value="/creationCommande"/>">
						 <fieldset>
							 <legend class="h4">Informations client</legend>
							 <c:import url="/inc/inc_client_form.jsp"/>
					 	</fieldset>
					 	
						<fieldset>
						<legend class="h4">Informations commande</legend>
						
						<label for="dateCommande">Date <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />
						
						<label for="montantCommande">Montant <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20" />
						
						<label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="modePaiementCommande" name="modePaiementCommande" value="" size="20" maxlength="20" />
						
						<label for="statutPaiementCommande">Statut du paiement</label>
						<input type="text" class="form-control form-control-sm" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="20" />
						
						<label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
						<input type="text" class="form-control form-control-sm" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="20" maxlength="20" />
		
						<label for="statutLivraisonCommande">Statut de la livraison</label>
						<input type="text" class="form-control form-control-sm" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="20" />
						<br>
						</fieldset>
						<input type="submit" class="btn btn-outline-primary btn-sm" value="     Valider     " />
						<input type="reset" class="btn btn-outline-danger btn-sm"   value="Remettre à zéro" /> <br />
					</form>
				</div>
			</div>
		</div><br>
	</body>
</html>