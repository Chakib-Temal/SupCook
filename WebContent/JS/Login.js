/**
 * 
 */

$(document).ready(function(){

    $("#userName").on("propertychange input", function(e){
    	var value = $(this).val();
		if(value.length >2 && value.length <=9){
			$(this).css("border-color", "green");
			$("#errorUserName").hide();
			$("#corUserName").text("it's ok");
		}else {
			$(this).css("border-color", "red");
			$("#errorUserName").hide();
			$("#corUserName").text("it's wrong");
		}
	});
    
    $("#password").on("propertychange input", function(e){
    	if( /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}$/.test($(this).val())){
    		$(this).css("border-color", "green");
    		$("#errorPassword").hide();
			$("#corPassword").text("it's ok");
    	}else {
    		$(this).css("border-color", "red");
    		$("#errorPassword").hide();
			$("#corPassword").text("it's wrong");
    	}
    });
    
  
});