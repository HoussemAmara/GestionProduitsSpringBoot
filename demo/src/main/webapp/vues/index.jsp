<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
       <form class="form-inline" method="get" action="controleur">
        <button type="submit"class="nav-link" name="action"value="displayProduits">Produits</button>
      </form>
      </li>
      <li class="nav-item">
      <form class="form-inline" method="get" action="controleur">
        <button type="submit"class="nav-link" name="action"value="displayCategories">Categories</button>
      </form>
      </li>
      
    </ul>
  </div>
</nav>
    <h1>List of Products</h1>
<form class="form-inline" method="get" action="search">
  <div class="form-group mb-2">
    <label for="searchInput" class="sr-only">Search</label>
    <input type="text" class="form-control" id="searchInput" name="mc">
  </div>
  <button type="submit" class="btn btn-primary mb-2"name="action"value="recherche">Search</button>
	<button type="submit"class="btn btn-success float-right"name="action"value="ajouter"> <i class="fas fa-plus"></i></button>
</form>
    <div class="container">
        <div class="row">
            <c:forEach items="${productList}" var="product">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <h5 class="card-header">${product.nom}</h5>
                        <div class="card-body">
                        	<h5 class="btn btn-dark">${product.categorie.nom}</h5>
                            <h5 class="card-title">ID: ${product.id}</h5>
                            <p class="card-text">Price: ${product.prix}</p>
                            <p class="card-text">Quantity: ${product.quantite}</p>
                            <a href="#" class="btn btn-primary">Buy Now</a>
                        	<form class="form-inline" method="get" action="controleur">
							  <input type="hidden" name="productId" value="${product.id}" />
							  <button type="submit"class="btn btn-danger float-right"name="action"value="supprimer">
							  <a href="delete/${p.id}">
	                            <i class="fas fa-trash"></i>
							  </a>
                        	  </button>
	                          <button type="submit"class="btn btn-warning float-right"name="action"value="edit">
	                            <i class="fas fa-edit"></i>
                        	  </button>
							</form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>