var config = require('../config')();
var http = require("http");
var crypto = require("crypto");

exports.getStaffListByUID = function(uid, callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.staffListByUID + uid,
		method : 'GET',
		headers : postheaders
	};

	var reqPost = http.request(options, function(res) {
		res.setEncoding('utf8');

		res.on('data', function(chunk) {
			// get Y and uid
			var chunkObj = JSON.parse(chunk);
			if (chunkObj.count !== 0) {
				callback(chunkObj.contents);
			} else {
				callback(null);
			}
		});
	});

	reqPost.end();
	reqPost.on('error', function(e) {
		callback(e.message);
	});
};