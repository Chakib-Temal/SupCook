<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
</head>
<body>
	<c:if test="${sessionScope.user != null}">
		<jsp:include page="NavBarConnected.jsp" />
	</c:if>
	<c:if test="${sessionScope.user == null}">
		<jsp:include page="NavBar.jsp" />
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Name of Publisher :</label>
				<c:if test = "${sessionScope.user.userName == cook.namePublisher}">
					<span class="lead"> it's you </span>
				</c:if>
				<c:if test = "${sessionScope.user.userName != cook.namePublisher}">
					<span class="lead"> ${cook.namePublisher } </span>
				</c:if>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Name of Cook :</label>
				<span class="lead"> <strong> <em> ${cook.name } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Category :</label>
				<span class="lead"> <strong> <em> ${cook.category } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Description :</label>
				<span class="lead"> <strong> <em> ${cook.description } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Time needed to Preparing :</label>
				<span class="lead"> <strong> <em> ${cook.timeP } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Time needed to Food :</label>
				<span class="lead"> <strong> <em> ${cook.timeF } </em> </strong> </span>
		   </div>
		</div>
				
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Difficulte Level :</label>
				<span class="lead"> <strong> <em> ${cook.level } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="name" class="lead">Date of Publication :</label>
				<span class="lead"> <strong> <em> ${cook.datePublication } </em> </strong> </span>
		   </div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<img  src="/SupCook/${cook.namePhoto }" class="img-responsive center-block" style="">
		   </div>
		</div>
		
	</div>
</body>
</html>