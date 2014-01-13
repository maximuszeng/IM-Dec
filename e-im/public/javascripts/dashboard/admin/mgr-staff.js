function loadStaffFromWebAPI() {
	
	$("#loadingWaitDialog").modal('show');
	
	var uid = $("#uid").val();
	
	// invoke webapi to load staff list
	 var request = $.ajax({
	        url: "http://localhost:8080/webapi/api/staff/list/" +uid,
	        contentType: "application/json; charset=utf-8" ,
	        crossDomain: true,
	        dataType: "json",
	        type: "get"
	 });
	 
	 request.done(function (response, textStatus, jqXHR){
		 if(response.count != 0) {
			 $("#staffListTable tbody").append(templates.StaffMgrRow.render(response));
			 renderStaffTableAfterTableLoad();
			 renderStaffTableEditable();
		 } else {
		 }
	 });

	 // callback handler that will be called on failure
	 request.fail(function (jqXHR, textStatus, errorThrown){
	 });

	 // callback handler that will be called regardless
	 // if the request failed or succeeded
	 request.always(function () {
		 $("#loadingWaitDialog").modal('hide');
	 });
}

function renderStaffTableAfterTableLoad(){
	$('.selectpicker').selectpicker();
	$('.checkbox').checkbox();
	$("#staffListTable").find(".selectpicker").prop('disabled', true);
	$("#staffListTable").find(".selectpicker").selectpicker('refresh');
	$("#staffListTable").find(".make-switch").bootstrapSwitch('setActive', false);
	$("#staffListTable").find(".editable").editable('toggleDisabled');
	$("#staffListTable .make-switch").bootstrapSwitch();
	
	$('.DeleteStaffHyperLink').click(function() {
		var uid = $("#uid").val();
		var pk = $(this).attr("pk");
		$('#deleteDataConfirmModal').find('.modal-body').text($(this).attr('data-confirm'));
		$('#deleteDataConfirmModal').modal({show:true});
		$('#deleteDataConfirmOK').unbind('click');
		
		$('#deleteDataConfirmOK').click(function(){
			$("#deleteDataConfirmModal").modal('hide');
			$("#pleaseWaitDialog").modal('show');
			// invoke webapi to load staff list
			var request = $.ajax({
				url : "http://localhost:8080/webapi/api/staff/delete/"+pk,
				contentType : "application/json; charset=utf-8",
				crossDomain : true,
				dataType : "json",
				type : "DELETE"
			});
	
			request.done(function(response, textStatus, jqXHR) {
				if (response.status === 'Y') {
					alert('success');
				} else {
				}
			});
	
			// callback handler that will be called on failure
			request.fail(function(jqXHR, textStatus, errorThrown) {
			});
	
			// callback handler that will be called regardless
			// if the request failed or succeeded
			request.always(function() {
				$("#pleaseWaitDialog").modal('hide');
			});
		});
	});
}

function renderStaffTableEditable(){
	$('#staffListTable .cell-name').editable({
		type : 'text',
		name : 'username',
		url : '/post',
		title : 'Enter Name',
		validate: function(value) {
		    if($.trim(value) == '') {
		        return 'This field is required';
		    }
		}
	});

	$('#staffListTable .cell-email').editable({
		type : 'text',
		name : 'username',
		url : '/post',
		title : 'Enter Email'
	});
	
	setInEditingMode(false);
}

function setInEditingMode(editingMode) {
	$('#newStaff').prop('disabled', editingMode);
	if (editingMode) {
		$('#editMode').addClass("hidden");
		$('#editingMode').removeClass("hidden");
	} else {
		$('#editMode').removeClass("hidden");
		$('#editingMode').addClass("hidden");
	}
	
	$("#staffListTable").find(".make-switch").bootstrapSwitch('setActive', editingMode);
	$("#staffListTable").find(".selectpicker").prop('disabled', !editingMode);
	$("#staffListTable").find(".selectpicker").selectpicker('refresh');
	
	$('#staffListTable .editable').editable('toggleDisabled');
}

function bindComponentsEvents(){
	$('#newStaff').click(function() {
		
	});
	
	$('#editMode,#editingMode').click(function() {
		var inEditing = $('#newStaff').prop('disabled');
		if (inEditing) {
			setInEditingMode(false);
		} else {
			setInEditingMode(true);
		}
	});
}

$(document).ready(function() {
	loadStaffFromWebAPI();
	bindComponentsEvents();
});