			request.fail(function(jqXHR, textStatus, errorThrown) {
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
