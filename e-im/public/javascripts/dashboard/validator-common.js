$(document).ready(function() {

	jQuery.validator.addMethod("onlyNumAndLet", function(value, element) {
		var chrnum = /^([a-zA-Z0-9]+){6,50}$/;
		return this.optional(element) || (chrnum.test(value));
	}, "Enter only numbers and letters(letters A-Z, a-z, 0-9)");

	jQuery.validator.addMethod("domain", function(value, element) {
		var chrnum = /^(?!:\/\/)([a-zA-Z0-9]+\.)?[a-zA-Z0-9][a-zA-Z0-9-]+\.[a-zA-Z]{2,6}?$/i;
		return this.optional(element) || (chrnum.test(value));
	}, "Enter valid domain name without http, sample: www.yourdomain.com)"); 
	
	
});