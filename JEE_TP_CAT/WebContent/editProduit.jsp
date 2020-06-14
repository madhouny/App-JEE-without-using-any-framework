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
<title>Editer des Produits</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2">
		<div class="card ">
			<div class="card-header">Editer un produit</div>
			<div class="card-body">

				<form action="update.do" method="post">
				<div class="form-group">
						<label class="control-label">ID:</label> <input
							type="text" name="id" class="form-control" value="${produit.id }" required="required">
					</div>
					
					<div class="form-group">
						<label class="control-label">Designation</label> <input
							type="text" name="designation" class="form-control" value="${produit.designation }" required="required">
					</div>
					
					<div class="form-group">
						<label class="control-label">Prix</label> <input
							type="text" name="prix" class="form-control"  value="${produit.prix }">
					</div>
					
					<div class="form-group">
						<label class="control-label">Quantite</label> <input
							type="text" name="quantite" class="form-control"  value="${produit.quantite }">
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>

			</div>
		</div>
</body>
</html>