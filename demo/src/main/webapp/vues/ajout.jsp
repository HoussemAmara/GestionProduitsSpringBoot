<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form method="get"action="controleur">
  <div class="form-group">
    <label for="exampleInputEmail1">Product name:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="product"name="productName">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Price:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="57.99$"name="productPrice">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Product quantity:</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="20"name="productQuantity">
  </div>
  <div class="form-group">
	  <select class="form-control form-control-sm" name="selectedCategorie">
	  <c:forEach items="${categorieList}" var="categorie">
            <option value=${categorie.id}>${categorie.nom}</option>
      </c:forEach>
	  </select>
  </div>
  <button type="submit" class="btn btn-primary" name="action" value="ajoutProduit">Submit</button>
</form>
</body>
</html>