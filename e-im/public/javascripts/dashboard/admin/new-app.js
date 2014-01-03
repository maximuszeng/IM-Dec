window.CKEDITOR_BASEPATH =  "http://mydomain.com/new";

CKEDITOR.replace("welcomeMsg",{
	customConfig: '/javascripts/dashboard/admin/ckeditor-wm-config.js'
});

$(document).ready(function() {
	var _FORM = "#newAppForm";
	var _RESET = "#resetNewApp";
	var _SAVE = "#saveNewApp";
	
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
	
	// Adding custom typeahead support using http://twitter.github.io/typeahead.js
	var elt = $('.apptag > input');
	elt.tagsinput({
	  itemValue: 'value',
	  itemText: 'text'
	});
	
//	elt.tagsinput('add', { "value": 1 , "text": "Amsterdam"   , "continent": "Europe"    });
//	elt.tagsinput('add', { "value": 4 , "text": "Washington"  , "continent": "America"   });
//	elt.tagsinput('add', { "value": 7 , "text": "Sydney"      , "continent": "Australia" });
//	elt.tagsinput('add', { "value": 10, "text": "Beijing"     , "continent": "Asia"      });
//	elt.tagsinput('add', { "value": 13, "text": "Cairo"       , "continent": "Africa"    });
	
	elt.tagsinput('input').typeahead({
	  valueKey: 'text',
	  prefetch: '/javascripts/dashboard/admin/cities.json',
	  template: '<p>{{text}}</p>',                                       
	  engine: Hogan

	}).bind('typeahead:selected', $.proxy(function (obj, datum) {  
		this.tagsinput('add', datum);
		this.tagsinput('input').typeahead('setQuery', '');
	}, elt));
	
	$("#saveNewApp").click(function(event) {
		$("#newStaffForm").submit(function(e) {
			e.preventDefault();
			 var $form = $(this);
			 var $inputs = $form.find("input, select, button, textarea");
			 
			 var serializedData = $inputs.serialize();
			 
			 $inputs.prop("disabled", true);
			 
			 /*request = $.ajax({
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
			 });*/
		});
	});

});