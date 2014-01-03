$(document).ready(function(){
	var connected = false;
	var _TOUSER_INPUT = "#toUserInput";
	var _TOUSER_GROUP = "#toUserGroup";
	
	var _YOURNAME_INPUT = "#yourNameInput";
	var _YOURNAME_GROUP = "#yourNameGroup";
	
	var _MESSAGE_INPUT = "#messageInput";
	var _MESSAGE_GROUP = "#messageGroup";
	
	var _ACTION_CONNECT = "#connectBtn";
	var _ACTION_SEND = "#sendBtn";
	var _ACTION_DISCONNECT = "#disconnectBtn";
	
	var _CONTAINER_CHAT = "#container";
	var _SOCKET;
	var _SOCKET_DATA;
	
	function validateInput(inputId, formGroupId) {
		 var val = $(inputId).val();
		 if (val == '') {
			 $(formGroupId).addClass('has-error');
			 $(formGroupId).effect("shake");
			 return false;
		 } else {
			 $(formGroupId).removeClass('has-error');
			 return true;
		 }
	}
	
	function waiting() {
		$("body").addClass("loading"); 
	}
	
	function finish() {
		$("body").removeClass("loading"); 
	}
	
	function afterConnectSuccess(data) {
		finish();
		$(_MESSAGE_INPUT).val("");
		$(_MESSAGE_INPUT).blur(function(){
			validateInput(_MESSAGE_INPUT, _MESSAGE_GROUP);
		});
		$(_ACTION_CONNECT).attr("disabled", true);
		$(_ACTION_SEND).attr("disabled", false);
		$(_ACTION_DISCONNECT).attr("disabled", false);
		
	}
	
	$(_ACTION_CONNECT).click(function(){
			waiting();
			_SOCKET = io.connect('http://localhost:3000', function() {
				//_SOCKET.emit('setName', $(_TOUSER_INPUT).val());
			});
			
			connected = true;
			_SOCKET.on('message', function(data) {
				if (data.uid) {
					$(_YOURNAME_INPUT).val(data.uid);
				}
				afterConnectSuccess(_SOCKET_DATA);
				if (data.message) {
					var message;
					if (data.from) {
						var message = "<p class='triangle-isosceles right'>" + data.message + ". from "+ data.from +  "</p>";
					} else {
						var message = "<p class='triangle-isosceles top'>" + data.message + "</p>";
					}
					
					$(_CONTAINER_CHAT).append(message);
				} else {
					
				}
			});
	});
	
	
	$(_ACTION_SEND).click(function(){
		var result = validateInput(_YOURNAME_INPUT, _YOURNAME_GROUP);
		var result1 = validateInput(_TOUSER_INPUT, _TOUSER_GROUP);
		var result2 = validateInput(_MESSAGE_INPUT, _MESSAGE_GROUP);
		
		if(result && result1 && result2) {
			var text = $(_MESSAGE_INPUT).val();
			var user = $(_TOUSER_INPUT).val();
			
			var messageObj = {
				message:text,
				to:user
			}
			
			var message = "<p class='triangle-isosceles left'>" + text + "</p>";
			$(_CONTAINER_CHAT).append(message);
			
			_SOCKET.emit('send', messageObj, function(data){
				alert('aaa');
			});
			
			$(_MESSAGE_INPUT).val("");
		}
	});
	
	$(_ACTION_SEND).attr("disabled", true);
	$(_ACTION_DISCONNECT).attr("disabled", true);
});