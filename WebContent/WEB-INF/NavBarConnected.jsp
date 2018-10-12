<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a style="color : white;" class="navbar-brand"  > Hello <c:out value="${sessionScope.user.userName }"/></a>>
	      <a class="navbar-brand" href="/SupCook/Home">Home</a>
	    </div>
	    <ul class="nav navbar-nav">
	      
	      <li><a href="/SupCook/Login">Profil</a></li>
	      <li><a href="/SupCook/LogOut">LogOut</a></li>
	      <li><a href="/SupCook/CookUser">My Cooks</a></li>
	      <li><a href="/SupCook/AddCooks">Add Cook</a></li>
	      
	    </ul>
	    <form class="navbar-form navbar-left" action="SearchEngine">
      		<div class="form-group">
       			<input type="text" name="caractere" class="form-control" placeholder="Search">
      		</div>
      		<button type="submit" class="btn btn-default">Submit</button>
    		</form>
	  </div>
</nav>