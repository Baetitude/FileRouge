<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title >Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/bootstrap-4.5.0-dist/css/bootstrap.min.css" />
    </head>
    <body>
	<div class="container">
	    <br>
	    <div class="row">
		    <div class="col-md-4">
			    <form method="get" action="creationClient">
				    <fieldset>
				        <legend class="h4">Informations client</legend>
				    </fieldset>
			        <input type="submit" class="btn btn-outline-primary btn-sm" value="      Valider      "  />
			        <input type="reset" class="btn btn-outline-danger btn-sm"   value="Remettre à zéro" /> <br />
			    </form>
	    	</div>
	    </div>
    </div>
    </body>
</html>