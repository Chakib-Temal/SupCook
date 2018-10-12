<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Cook</title>

</head>
<body>
	<jsp:include page="NavBarConnected.jsp" />
	<div class="container">
		<div class="row">
			<h3>Your cooks</h3>
		</div>
		<div class="row">
			<table class="table table-dark">
 				<thead>
    				<tr>
					    <th scope="col">id</th>
					    <th scope="col">Name</th>
					    <th scope="col">Category</th>
			            <th scope="col">date of publication</th>
			            <th scope="col">Choose</th>
    				</tr>
 				</thead>
  				<tbody>
  				<c:forEach items="${listCook}" var="cook" > 
	   				<tr>
				      	<th scope="row"> ${cook.id }</th>
				      	<td>${cook.name }</td>
				      	<td>${cook.category }</td>
				      	<td>${cook.datePublication }</td>
				      	<td>
				      		<select name="choose" class="choose">
					      		<option value=""></option>
					      		<option value="ViewCook" id="${cook.id }" >View</option>
					      		<option value="EditCook" id="${cook.id }">Edit</option>
					      		<option value="RemoveCook" id="${cook.id }" >Remove</option>
				      		</select>
				      	</td>
	    			</tr>
    			</c:forEach>
  	  			</tbody>
			</table>
		</div>
	</div>
	<script>
		$(document).ready(function(){
		    $(".choose").change(function(){
		    	var servlet = $(this).val();
		    	var id = $(this).children(":selected").attr("id");
		    	if (typeof id === 'undefined'){
		    		return 0;
		    	}
		    	window.location = "/SupCook/"+servlet+"?id="+id;
		    });
		});
	</script>
</body>

</html>