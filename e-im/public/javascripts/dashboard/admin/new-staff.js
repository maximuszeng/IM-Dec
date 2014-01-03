$(document).ready(function() {
	var _FORM = "#newStaffForm";
	var _RESET = "#resetNewStaff";
	var _SAVE = "#saveNewStaff";
	
	var v = $(_FORM).validate();
	
	function resetElement(value) {
		$(value).val("");
	}
	
	$(_RESET).click(function(event) {
		v.resetForm();
		$(_FORM).find("input[type='text']").each(function(index, value) {
			resetElement(value);
	    });
		$(_FORM).find("input[type='password']").each(function(index, value) {
			resetElement(value);
		});
		$(_FORM).find(".has-error").each(function(index, value) {
			$(value).removeClass("has-error");
		});
		$(_FORM).find(".has-success").each(function(index, value) {
			$(value).removeClass("has-success");
		});
	});
	
	$(_SAVE).click(function(event) {
		if ($(_FORM).valid()) {
			 //$("#pleaseWaitDialog").modal('show');
			 
			 var serializedData = $(_FORM).serializeJSON();
			 if (serializedData.canServe && serializedData.canServe == 'on') {
				 serializedData.canServe = true;
			 }
			 
			 if (serializedData.serviceMode && serializedData.serviceMode == 'on') {
				 serializedData.serviceMode = "ONETOMANY";
			 }
			 
			 var data = JSON.stringify(serializedData);
			 var request = $.ajax({
			        url: "http://localhost:8080/webapi/api/staff/new",
			        contentType: "application/json; charset=utf-8" ,
			        crossDomain: true,
			        dataType: "json",
			        type: "post",
			        data: JSON.stringify(serializedData)
			 });
			 
			 request.done(function (response, textStatus, jqXHR){
				 if(response.status == 'Y') {
					 alert("success");
					 $("#resetNewStaff").click();
				 } else {
					 alert(response.errorMessage);
				 }
			 });

			 // callback handler that will be called on failure
			 request.fail(function (jqXHR, textStatus, errorThrown){
				 alert(errorThrown);
			     alert("The following error occured: "+ textStatus + errorThrown);
			 });

			 // callback handler that will be called regardless
			 // if the request failed or succeeded
			 request.always(function () {
				 $("#pleaseWaitDialog").modal('hide');
			 });
		}
	});

	$('#canServe').on('switch-change', function(e, data) {
		initComponentsByCanServeFlag(data.value);
	});
	
	$('#OTMMode').on('switch-change', function(e, data) {
		if (!data.value) {
			$('#OTMConcurrentLimited').val(1);
			setBootstrapSelect('#OTMConcurrentLimited', true);
		} else {
			$('#OTMConcurrentLimited').val(3);
			setBootstrapSelect('#OTMConcurrentLimited', false);
		}
	});
	
	initComponentsByCanServeFlag();
	
	function initComponentsByCanServeFlag(disableArg){
		var disable = (disableArg != undefined )? disableArg : $('#canServe').bootstrapSwitch('isActive');
		setBootstrapSwitchDisable('#OTMMode', disable);
		setBootstrapSelect('#canServeApps', !disable);
		setBootstrapSelect('#OTMConcurrentLimited', !disable);
	}

});