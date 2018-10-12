<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Register</title>
</head>
<body>

	<jsp:include page="NavBar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<form action="Inscription" method="post" >
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="userName" class="lead">Enter your Username</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="text" name="userName" id="userName" class="form-control" value="${userName }" required>
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorUserName"> <c:out value="${errorUserName }"></c:out> <c:out value="${usernameExiste }"></c:out> </span> <span class="lead" id="corUserName"></span>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="firstName" class="lead">Enter your FirstName</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="text" name="firstName" id="firstName" class="form-control textJs" value="${firstName }" required>
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorFirstName"> <c:out value="${errorFirstName }"></c:out> </span> <span	class="lead"  id="corFirstName"></span>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="lastName" class="lead">Enter your lastName</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="text" name="lastName" id="lastName" class="form-control textJs" value="${lastName }" required">
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorLastName"> <c:out value="${errorLastName }"></c:out> </span> <span	class="lead"  id="corLastName"></span>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="email" class="lead">Enter your email</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="email" name="email" id="email" class="form-control" value="${email }" required">
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorEmail"> <c:out value="${errorEmail }"></c:out> </span> <span	class="lead"  id="corEmail"></span>
					</div>
				</div>
			    
			    
			    <div class="row">
					<div class="col-md-5 text-center">
						<label for="password" class="lead">Enter your password</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="password" name="password" id="password" class="form-control" value="${password }" required">
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorPassword" > <c:out value="${errorPassword }"></c:out> </span> <span	class="lead"  id="corPassword"></span>
					</div>
				</div>	
				
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="postalCode" class="lead">Enter your postalCode</label>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-5">
						<input type="number" name="postalCode" id="postalCode" class="form-control" value="${postalCode }" required">
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorPostalCode"> <c:out value="${errorPostalCode }"></c:out> </span> <span	class="lead"  id="corPostalCode"></span>
					</div>
				</div>		 
				
				<div class="row">
					<div class="col-md-5 text-center">
						<input type="submit" value="Register" class="btn btn-primary btn-lg">
					</div>
				</div>
				</form>		
			</div>
		</div>
	</div>

	<script src="/SupCook/JS/Login.js"></script>
	<script src="/SupCook/JS/Inscription.js"></script>
</body>
</html>