$(document).ready(function() {
	var path = location.pathname;
	var pathHref = $("[href$='" + path + "']").parent().parent().parent();
	$(".active").removeClass("active");
	pathHref.addClass("active");
	
	$.validator.setDefaults({
		highlight : function(element) {
			$(element).closest('.form-group').removeClass(
					'has-success').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass(
					'has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		success : function(element) {
			element.closest('.form-group').removeClass('has-error')
					.addClass('has-success');
		},
		errorPlacement : function(error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element);
			} else {
				error.insertAfter(element);
			}
		}
	});

	$('[data-toggle=tooltip]').mouseover(function() {
		$(this).tooltip('show');
	});
	
	$('.checkbox').checkbox();

	$('#serveAMReadyBtn').click(function() {
		var request = $.ajax({
			url : "/staff/status/standby",
			type : "post"
		});

		request.done(function(response, textStatus, jqXHR) {
			// log a message to the console
			if (response == 'Y') {
				$("#serveAMReadyBtn").addClass("hidden");
				$("#serveingBtn").removeClass("hidden");
			} else {
				alert(response);
			}
		});

		// callback handler that will be called on failure
		request.fail(function(jqXHR, textStatus, errorThrown) {
			alert("The following error occured: " + textStatus, errorThrown);
		});

	});

	$('#serveingBtn').click(function() {
		var request = $.ajax({
			url : "/staff/status/serveend",
			type : "post"
		});

		request.done(function(response, textStatus, jqXHR) {
			// log a message to the console
			if (response == 'Y') {
				$("#serveingBtn").addClass("hidden");
				$("#serveAMReadyBtn").removeClass("hidden");
			} else {
				alert(response);
			}
		});

		// callback handler that will be called on failure
		request.fail(function(jqXHR, textStatus, errorThrown) {
			alert("The following error occured: " + textStatus, errorThrown);
		});

		// callback handler that will be called regardless
		// if the request failed or succeeded
		request.always(function() {
		});

	});

	jQuery.validator.addMethod("onlyNumAndLet", function(value, element) {
		var chrnum = /^([a-zA-Z0-9]+){6,50}$/;
		return this.optional(element) || (chrnum.test(value));
	}, "Enter only numbers and letters(letters A-Z, a-z, 0-9)");
	
	$('.selectpicker').selectpicker();

	$('.popover-auto').popover({
		placement : "auto",
		trigger : "hover"
	});
	$('.popover-bottom').popover({
		placement : "bottom",
		trigger : "hover"
	});
	$('.popover-left').popover({
		placement : "left",
		trigger : "hover"
	});
	$('.popover-top').popover({
		placement : "top",
		trigger : "hover"
	});
	

});


function setBootstrapSwitchDisable(id, disable) {
	$(id).bootstrapSwitch('setActive', disable);
}

function setBootstrapSelect(id, disable) {
	$(id).prop('disabled', disable);
	$(id).selectpicker('refresh');
}
