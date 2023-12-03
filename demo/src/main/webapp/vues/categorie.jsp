<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<style>
	        
	        .black-icon {
	            color: black;
	}
    </style> 
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Something</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="/produits">Produits</a>
    </li>
      <li class="nav-item">
      <a class="nav-link" href="/categories">Categories</a>
      </li>
      
    </ul>
  </div>
</nav>
    <h1>List of Categories</h1>
<form class="form-inline" method="get" action="/categories/search">
  <div class="form-group mb-2">
    <label for="searchInput" class="sr-only">Search</label>
    <input type="text" class="form-control" id="searchInput" name="mc">
  </div>
  <button type="submit" class="btn btn-primary mb-2"name="action"value="rechercheCategorie">Search</button>
	 <a href="/categories/ajouter"class="btn btn-success float-right">
		<i class="fas fa-plus black-icon"></i>
	</a>
</form>
    <div class="container">
        <div class="row">
            <c:forEach items="${categorieList}" var="categorie">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <h5 class="card-header">${categorie.nom}</h5>
                        <div class="card-body">
                            <h5 class="card-title">ID: ${categorie.id}</h5>
							  <input type="hidden" name="categorieId" value="${categorie.id}" />
							  <button type="submit"class="btn btn-danger float-right"name="action"value="supprimer">
							  <a href="/categories/delete/${categorie.id}">
	                            <i class="fas fa-trash black-icon"></i>
							  </a>
                        	  </button>
	                          <button type="submit"class="btn btn-warning float-right"name="action"value="edit">
	                            <a href="/categories/${categorie.id}">
	                            <i class="fas fa-edit black-icon"></i>
	                            </a>
                        	  </button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>