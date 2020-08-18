<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				
      <label for="nomClient">Nom <span class="requis">*</span></label>
      <input type="text" class="form-control form-control-sm" id="nomClient" name="nomClient" value="<c:out value="${client.nom}"/>"  size="20" maxlength="20" />
      <span class="info">${ form.erreurs['nomClient'] }</span>
      
      <label for="prenomClient">Prénom </label>
      <input type="text" class="form-control form-control-sm" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20" />
      <span class="info">${ form.erreurs['prenomClient'] }</span>

      <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
      <input type="text" class="form-control form-control-sm" id="adresseClient" name="adresseClient" value="" size="20" maxlength="20" />
      <span class="info">${ form.erreurs['adresseClient'] }</span>

      <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
      <input type="text" class="form-control form-control-sm" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
      <span class="info">${ form.erreurs['telephoneClient'] }</span>
      
      <label for="emailClient">Adresse email</label>
      <input type="email" class="form-control form-control-sm" id="emailClient" name="emailClient" value="" size="20" maxlength="60" />
      <span class="info">${ form.erreurs['emailClient'] }</span>
      
      <label for="imageClient">Image</label>
	  <input type="file" class="form-control form-control-sm" id="imageClient" name="imageClient" />
      <span class="info">${form.erreurs['imageClient']}</span>
<br>
				    