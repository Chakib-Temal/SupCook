/**
 * 
 */


$(document).ready(function(){
	
	$("#nameCook").on("propertychange input", function(e){
    	var value = $(this).val();
		if(value.length >2 && value.length <=9){
			$(this).css("border-color", "green");
			$("#errorNameCook").hide();
			$("#corNameCook").text("it's ok");
		}else {
			$(this).css("border-color", "red");
			$("#errorNameCook").hide();
			$("#corNameCook").text("it's wrong");
		}
	});
	
	$("#description").on("propertychange input", function(e){
    	var value = $(this).val();
		if(value.length >2 && value.length <=40){
			$(this).css("border-color", "green");
			$("#errorDescription").hide();
			$("#corDescription").text("it's ok");
		}else {
			$(this).css("border-color", "red");
			$("#errorDescription").hide();
			$("#corDescription").text("it's wrong");
		}
	});
	
	$(".numberJs").on("propertychange input", function(e){
    	var value = $(this).val();
    	var pattern = /\d+$/;
    	
    	if ($(this).attr("name") === "timeP"){
    		if(pattern.test(value)){
    			$(this).css("border-color", "green");
    			$("#errorTimeP").hide();
    			$("#corTimeP").text("it's ok");
    		}else {
    			$(this).css("border-color", "red");
    			$("#errorTimeP").hide();
    			$("#corTimeP").text("it's wrong");
    		}
    	}else if ($(this).attr("name") === "timeC"){
    		if(pattern.test(value)){
    			$(this).css("border-color", "green");
    			$("#errorTimeC").hide();
    			$("#corTimeC").text("it's ok");
    		}else {
    			$(this).css("border-color", "red");
    			$("#errorTimeC").hide();
    			$("#corTimeC").text("it's wrong");
    		}	
    	}
	});
});