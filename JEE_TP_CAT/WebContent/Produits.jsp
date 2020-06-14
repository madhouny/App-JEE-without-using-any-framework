<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<title>Rechercher des Produits</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container col-md-10 col-md-offset-1">
		<div class="card ">
			<div class="card-header">Rechercher des produits</div>
			<div class="card-body">

				<form action="chercher.do" method="get">
					<div class="form-group">
						<label>Mot Clé:</label> <input type="text" name="motcle"
							class="form-control" value="${model.motCle }" />
							
						<button type="submit" class="btn btn-primary">Chercher</button>
					</div>
				</form>
				<p>
				<table class="table1">
					<tr>
						<th>ID</th>
						<th>DESIGNATION</th>
						<th>PRIX</th>
						<th>QUANTITE</th>
					</tr>
					<c:forEach items="${ model.produits}" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.designation }</td>
							<td>${p.prix }</td>
							<td>${p.quantite }</td>
							<td><a onclick="return confirm('Etes vous sure de vouloir supprimer ce produit ?')" href="delete.do?id=${p.id }">Delete</a></td>
							<td><a href="edit.do?id=${p.id }">Edit</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
</body>
</html>