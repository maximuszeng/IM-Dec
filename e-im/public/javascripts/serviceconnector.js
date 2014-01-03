$(document).ready(function(){
	// after 3 seconds, 
	
	setTimeout(getUseableSUID, 3000);
	var actualUrl =  "/serve/gusu/" + $('#appId').val() +"/" + $('#auId').val() +"";
	
	function getUseableSUID() {
		var request = $.ajax({
			url : actualUrl,
			type : "post"
		});
		request.done(function(response, textStatus, jqXHR) {
			// log a message to the console
			alert(response);
			if (response === 'N') {
				setTimeout(getUseableSUID, 3000);
			} else {
				window.location.href = '/chat?suid='+response;
			}
		});

		// callback handler that will be called on failure
		request.fail(function(jqXHR, textStatus, errorThrown) {
			setTimeout(getUseableSUID, 3000);
		});
	}
});