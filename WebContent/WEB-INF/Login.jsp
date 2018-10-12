<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>
</head>
<body>
	<jsp:include page="NavBar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-4"> </div>
			<div class="col-md-8">
			
				<div class="row">
					<h1 class="col-md-5 text-center">Login</h1>
				</div>
				
				<form action="Login" method="post" >
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="userName" class="lead" >Enter your UserName </label>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5">
						<input class="form-control" type="text" name="userName" id="userName" value="${userName }" required>
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorUserName"> <c:out value="${errorUserName }"></c:out> </span> <span class="lead" id="corUserName"></span>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5 text-center">
						<label for="password" class="lead" >Enter your Password </label>
					</div>	
				</div>
				
				<div class="row">
					<div class="col-md-5">
						<input class="form-control" type="password" name="password" id="password"   required>
					</div>
					<div class="col-md-5 text-center lead">
						<span id="errorPassword"> <c:out value="${errorPassword }"></c:out> </span> <span	class="lead"  id="corPassword"></span>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5 text-center">
						<span class="lead"  style="color: red;"  > <c:out value="${ErrorUser }"/>  </span>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5 text-center">
						<input type="submit" value="Login" class="btn btn-primary btn-lg">
					</div>
				</div>
				</form>
				
				<div class="row">
					<div class="col-md-5 text-center">
						<a href="Inscription">Create Account</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/SupCook/JS/Login.js"></script>
</body>
</html>