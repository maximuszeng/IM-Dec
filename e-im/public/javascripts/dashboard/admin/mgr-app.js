function loadStaffFromWebAPI() {

	$("#loadingWaitDialog").modal('show');

	var uid = $("#uid").val();

	// invoke webapi to load staff list
	var request = $.ajax({
		url : "http://localhost:8080/webapi/api/app/list/" + uid,
		contentType : "application/json; charset=utf-8",
		crossDomain : true,
		dataType : "json",
		type : "get"
	});

	request.done(function(response, textStatus, jqXHR) {
		if (response.count != 0) {
			$("#appListTable tbody").append(templates.AppMgrRow.render(response));
			bindComponentsAfterLoadSuccess();
		} else {
		}
	});

	// callback handler that will be called on failure
	request.fail(function(jqXHR, textStatus, errorThrown) {
	});

	// callback handler that will be called regardless
	// if the request failed or succeeded
	request.always(function() {
		$("#loadingWaitDialog").modal('hide');
	});
}

function bindComponentsAfterLoadSuccess() {
	$('.DeleteAppHyperLink').click(function() {
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
			url : "http://localhost:8080/webapi/api/app/delete/"+pk,
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

$(document).ready(function() {

	loadStaffFromWebAPI();
});