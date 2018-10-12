
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Home SupCook</title>
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
			<div class="col-md-4">
			</div>
			<div class="col-md-4 text-center">
				<p> <em>number of users  ${requestScope.numberOfUsers} </em></p>
				<p> <em>number of Articles Cooks  ${requestScope.numberOfCooks} </em></p>
			</div>
		</div>
		<div class="row">
			<h3>Here are the 5 lasts publications of cooks</h3>
		</div>
		<div class="row">
			<table class="table table-dark">
 	 			<thead>
    				<tr>
	     				 <th scope="col">id</th>
	     				 <th scope="col">Name</th>
	     				 <th scope="col">Category</th>
	     				 <th scope="col">date of publication</th>
    				</tr>
 	 			</thead>
  				<tbody>
  				<c:forEach items="${listCook}" var="cook" > 
	   				 <tr>
		     			 <th scope="row"> ${cook.id }</th>
					      <td>${cook.name }</td>
					      <td>${cook.category }</td>
					      <td>${cook.datePublication }</td>
					      <td> <a class="choose" id="${cook.id }" >View Cook</a> </td>
	    			</tr>
    			</c:forEach>
  	  			</tbody>
			</table>
		</div>
	</div>
	<script>
		$(document).ready(function(){
		    $("a.choose").bind('click', function(){
		        var id = ($(this).attr('id')); // gets the id of a clicked link that has a class of menu
		        console.log(id);
		        window.location = "/SupCook/ViewCook?id="+id;
		    });
		});
	</script>
</body>
</html>