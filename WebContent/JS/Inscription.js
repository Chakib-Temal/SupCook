/**
 * 
 */

$(document).ready(function(){
	
	$(".textJs").on("propertychange input", function(e){
    	var value = $(this).val();
    	if ($(this).attr("name") === "firstName"){
    		if(value.length >2 && value.length <=9){
    			$(this).css("border-color", "green");
    			$("#errorFirstName").hide();
    			$("#corFirstName").text("it's ok");
    		}else {
    			$(this).css("border-color", "red");
    			$("#errorFirstName").hide();
    			$("#corFirstName").text("it's wrong");
    		}
    	}else if ($(this).attr("name") === "lastName"){
    		if(value.length >2 && value.length <=9){
    			$(this).css("border-color", "green");
    			$("#errorLastName").hide();
    			$("#corLastName").text("it's ok");
    		}else {
    			$(this).css("border-color", "red");
    			$("#errorLastName").hide();
    			$("#corLastName").text("it's wrong");
    		}	
    	}
	});
    
	$("#email").on("propertychange input", function(e){
		var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i
		if( pattern.test($(this).val())){
    		$(this).css("border-color", "green");
    		$("#errorEmail").hide();
			$("#corEmail").text("it's ok");
    	}else {
    		$(this).css("border-color", "red");
    		$("#errorEmail").hide();
			$("#corEmail").text("it's wrong");
    	}
    });
	
	  
	$("#postalCode").on("propertychange input", function(e){
		var pattern = /\d+$/
		if( pattern.test($(this).val()) && $(this).val().length === 5){
    		$(this).css("border-color", "green");
    		$("#errorPostalCode").hide();
			$("#corPostalCode").text("it's ok");
    	}else {
    		$(this).css("border-color", "red");
    		$("#errorPostalCode").hide();
			$("#corPostalCode").text("it's wrong");
    	}
    });
});