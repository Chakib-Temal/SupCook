<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EditMyCook</title>
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
				<label for="name" class="lead">Date of Publication :</label>
				<span class="lead"> <strong> <em> ${cook.datePublication } </em> </strong> </span>
	   		</div>
		</div>
		
		<form action="EditCook"  method="post">
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="nameCook" class="lead">Enter name of Cook</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<input type="text" name="nameCook" id="nameCook" class="form-control" value="${cook.name }" required>
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorNameCook"> <c:out value="${errorNameCook }"></c:out>  </span> <span id="corNameCook"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="category" class="lead">Enter Category</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<select name="category" id="category" class="form-control" value="${cook.category }"  required> 
					<option value="tarte"> tarte </option>
					<option value="plat">plat </option>
					<option value="salade">salade </option>
					<option value="pizza">pizza </option>
				</select>
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorCategory"> <c:out value="${errorCategory }"></c:out>  </span> <span id="corCategory"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="description" class="lead">Enter Description</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<textarea name="description" id="description" class="form-control" required"><c:out value="${cook.description } "></c:out></textarea>
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorDescription"> <c:out value="${errorDescription }"></c:out>  </span> <span id="corDescription"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="timeP" class="lead">Enter time needed to cook</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<input type="number" name="timeP" id="timeP" class="form-control numberJs" value="${cook.timeP }" required"> 
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorTimeP"> <c:out value="${errorTimeP }"></c:out>  </span> <span id="corTimeP"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="timeC" class="lead">Enter Time to food</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<input type="number" name="timeC" id="timeC" class="form-control numberJs" value="${cook.timeF }" required">
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorTimeC"> <c:out value="${errorTimeC }"></c:out>  </span> <span id="corTimeC"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<label for="level" class="lead">Enter Difficulty</label>
	   		</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<select name="level" id="level" class="form-control" value="${cook.level }" required"> 
					<option value="1">1 </option>
					<option value="2">2 </option>
					<option value="3">3 </option>
					<option value="4">4</option>
					<option value="5">5 </option>
				</select>
	   		</div>
	   		<div class="col-md-4 lead">
				<span id="errorLevel"> <c:out value="${errorLevel }"></c:out>  </span> <span id="errorLevel"></span>
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<input type="text" name="id" value="${id }" style="background: transparent;border: none; color : transparent;">
	   		</div>
		</div>
		
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5 text-center">
				<input type="submit" value="Edit" class="btn btn-primary btn-lg">
	   		</div>
		</div>
		</form>
	</div>
	<script src="/SupCook/JS/CookValidator.js"></script>
</body>
</html>