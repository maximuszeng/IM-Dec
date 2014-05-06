$(document).ready(function() {
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

	//ajax emulation
	$.mockjax({
		url : '/post',
		responseTime : 200
	});

	
	
	$('#editMode,#editingMode').click(function() {
		var inEditing = $('#newStaff').prop('disabled');
		if (inEditing) {
			$('#newStaff').prop('disabled', false);
			$('#editingMode').addClass("hidden");
			$('#editMode').removeClass("hidden");
			$(".make-switch").bootstrapSwitch('setActive', false);
			$(".selectpicker").prop('disabled', true);
			$(".selectpicker").selectpicker('refresh');
		} else {
			$('#newStaff').prop('disabled', true);
			$('#editMode').addClass("hidden");
			$('#editingMode').removeClass("hidden");
			$(".make-switch").bootstrapSwitch('setActive', true);
		}
	});
}

});
