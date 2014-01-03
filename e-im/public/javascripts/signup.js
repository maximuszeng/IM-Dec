$(document).ready(function() {
	var _INPUT_NAME = "#name";
	var _INPUT_EMAIL = "#email";
	var _INPUT_PWD = "#password";
	var _ACTION_SIGNUP = "#signup";
	var _FORM = "#signupForm";
	
	$(_ACTION_SIGNUP).click(function() {
		
		$(_FORM).submit(function(event){
			event.preventDefault();
			if (validationForm()) {
				 var $form = $(this);
				 
				 var $inputs = $form.find("input, select, button, textarea");
				 
				 var serializedData = $form.serialize();
				 
				 $inputs.prop("disabled", true);
				 var request = $.ajax({
				        url: "/signuppost",
				        type: "post",
				        data: serializedData
				 });
				 
				 request.done(function (response, textStatus, jqXHR){
				     // log a message to the console
					 if (response == 'Y') {
						 window.location.href = "/signin";
					 } else {
						 $("#signupResult").html(response);
					 }
				 });

				 // callback handler that will be called on failure
				 request.fail(function (jqXHR, textStatus, errorThrown){
				      alert("The following error occured: "+ textStatus, errorThrown);
				 });

				 // callback handler that will be called regardless
				 // if the request failed or succeeded
				 request.always(function () {
				     $inputs.prop("disabled", false);
				 });
			}
		});
		
		$(_FORM).submit();
	});
	
	function validationForm() {
		var r = validateInput(_INPUT_NAME);
		var r1 = validateInput(_INPUT_PWD);
		var r2 = validateInput(_INPUT_EMAIL);
		return r && r1 && r2;
	}

	$(_INPUT_NAME).blur(function() {
		validateInput(_INPUT_NAME);
	});

	$(_INPUT_PWD).blur(function() {
		validateInput(_INPUT_PWD);
	});
	
	$(_INPUT_EMAIL).blur(function() {
		validateInput(_INPUT_EMAIL);
	});

});


function validateInput(inputId) {
	var val = $(inputId).val();
	if (val == '') {
		$(inputId+"FG").addClass('has-error');
		//$(formGroupId).effect("shake");
		return false;
	} else {
		$(inputId+"FG").removeClass('has-error');
		return true;
	}
}
