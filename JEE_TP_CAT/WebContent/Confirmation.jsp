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
<title>Confirmation</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2">
		<div class="card ">
			<div class="card-header">Confirmation </div>
			<div class="card-body">
			
			<div class="form-group">
				<label>ID:</label>
				<label>${produit.id }</label>
			</div>
			
				<div class="form-group">
				<label>DESIGNATION:</label>
				<label>${produit.designation }</label>
			</div>
			
				<div class="form-group">
				<label>PRIX:</label>
				<label>${produit.prix }</label>
			</div>
			
				<div class="form-group">
				<label>QUANTITE:</label>
				<label>${produit.quantite }</label>
			</div>
			

			</div>
		</div>
</body>
</html>