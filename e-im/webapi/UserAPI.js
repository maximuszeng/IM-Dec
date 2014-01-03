var config = require('../config')();
var http = require("http");
var crypto = require("crypto");

exports.signUp = function(name, email, password, callback) {
	var jsonObject = JSON.stringify({
		"password" : password,
		"email" : email,
		"name" : name
	});

	var postheaders = {
		'Content-Type' : 'application/json',
		'Content-Length' : Buffer.byteLength(jsonObject, 'utf8')
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.userregist,
		method : 'POST',
		headers : postheaders
	};

	var reqPost = http.request(options, function(res) {
		res.setEncoding('utf8');

		res.on('data', function(chunk) {
			// get Y and uid
			var chunkObj = JSON.parse(chunk);
			if (chunkObj.s == "Y") {
				callback(null, 'Y');
			} else {
				callback(chunk.em);
			}
		});
	});

	reqPost.write(jsonObject);
	reqPost.end();
	reqPost.on('error', function(e) {
		callback(e.message);
	});
}