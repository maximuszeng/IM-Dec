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
	var elt = $('.apptag > > input');
	elt.tagsinput({
		itemValue : 'value',
		itemText : 'text'
	});

	//	elt.tagsinput('add', { "value": 1 , "text": "Amsterdam"   , "continent": "Europe"    });

	elt.tagsinput('input').typeahead({
		valueKey : 'text',
		prefetch : '/javascripts/dashboard/admin/cities.json',
		template : '<p>{{text}}</p>',
		engine : Hogan

	}).bind('typeahead:selected', $.proxy(function(obj, datum) {
		this.tagsinput('add', datum);
		this.tagsinput('input').typeahead('setQuery', '');
	}, elt));

	$(_SAVE).click(function(event) {
		if ($(_FORM).valid()) {
			 $("#pleaseWaitDialog").modal('show');
			 
			 var serializedData = $(_FORM).serializeJSON();
			 
			 var data = JSON.stringify(serializedData);
			 var request = $.ajax({
			        url: "http://localhost:8080/webapi/api/app/regist",
			        contentType: "application/json; charset=utf-8" ,
			        crossDomain: true,
			        dataType: "json",
			        type: "post",
			        data: JSON.stringify(serializedData)
			 });
			 
			 request.done(function (response, textStatus, jqXHR){
				 if(response.status == 'Y') {
					 alert("success");
					 resetForm();
				 } else {
					 alert(response.errorMessage);
				 }
			 });

			 // callback handler that will be called on failure
			 request.fail(function (jqXHR, textStatus, errorThrown){
			     alert("The following error occured: "+ textStatus + errorThrown);
			 });

			 // callback handler that will be called regardless
			 // if the request failed or succeeded
			 request.always(function () {
				 $("#pleaseWaitDialog").modal('hide');
			 });
		
		}
	});

});
