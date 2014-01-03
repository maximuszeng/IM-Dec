$(document).ready(function() {
		var request;
		var _INPUT_NAME = "#name";
		var _INPUT_PWD = "#password";
		var _ACTION_SIGNIN = "#signin";
		var _FORM = "#signinForm";
		
		$(_FORM).submit(function(event){
			event.preventDefault();
			if (validationForm()) {
				 var $form = $(this);
				 
				 var $inputs = $form.find("input, select, button, textarea");
				 
				 var serializedData = $form.serialize();
				 
				 $inputs.prop("disabled", true);
				 
				 request = $.ajax({
				        url: "/signinpost",
				        type: "post",
				        data: serializedData
				 });
				 
				 request.done(function (response, textStatus, jqXHR){
				     // log a message to the console
					 if ($("#redirect").val() && (response == 'A' || response == 'Y')) {
						 window.location.href = $("#redirect").val();
						 return;
					 }
					 if (response == 'A') {
						window.location.href = "/admin/dashboard";
					 } if(response == 'Y') {
						 window.location.href = "/staff/dashboard";
					 } else {
						 $("#signinResult").html(response);
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
		
		$(_ACTION_SIGNIN).click(function() {
			$(_FORM).submit();
		});
		
		function enterKeyPressfunction(e) {
			 var code = e.keyCode || e.which;
			 if(code == 13) {
				 $(_FORM).submit();
			 }
		};
		
		$(_INPUT_NAME).bind('keypress', enterKeyPressfunction);
		$(_INPUT_PWD).bind('keypress', enterKeyPressfunction);
		
		function validationForm() {
			var r = validateInput(_INPUT_NAME);
			var r1 = validateInput(_INPUT_PWD);
			return r&r1;
		}

		$(_INPUT_NAME).blur(function() {
			validateInput(_INPUT_NAME);
		});

		$(_INPUT_PWD).blur(function() {
			validateInput(_INPUT_PWD);
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