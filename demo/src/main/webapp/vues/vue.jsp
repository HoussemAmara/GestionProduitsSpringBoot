<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<form method="get"action="controleur">
	<input type="hidden" name="productId" value="${product.id}" />
  <div class="form-group">
    <label for="exampleInputEmail1">Product name:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="productName"value="${product.nom}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Price:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="productPrice"value="${product.prix}">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Product quantity:</label>
    <input type="text" class="form-control" id="exampleInputPassword1"name="productQuantity"value="${product.quantite}">
  </div>
  <button type="submit" class="btn btn-primary" name="action" value="editProduit">
<c:if test="${produit.id==null}">add</c:if>
<c:if test="${produit.id!==null}">edit</c:if>
</button>
</form>
</body>
</html>