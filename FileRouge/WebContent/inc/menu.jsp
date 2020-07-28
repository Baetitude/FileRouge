<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link type="text/css" rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css" />
    
    <div class="container">
    <br>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		  <div class="collapse navbar-collapse" id="navbarCollapse">
		  
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href='<c:url value="/creationClient"/>'>Création Client</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="<c:url value="/creationCommande"/>">Création Commande</a>
		      </li>
		    </ul>
		    
		  </div>
		</nav>
	</div>