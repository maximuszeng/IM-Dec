var config = require('../config')();
var http = require("http");
var crypto = require("crypto");

exports.whenUserEnter = function(appid, data, callback) {
	var jsonObject = JSON.stringify({
		"appId" : appid,
		"ipAddress" : data.ip,
		"sessionId" : data.sessionID,
		"acceptLanguage" : data.acceptLang,
		"userAgent" : data.userAgent,
		"referer" : data.referrer
	});

	var postheaders = {
		'Content-Type' : 'application/json',
		'Content-Length' : Buffer.byteLength(jsonObject, 'utf8')
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.accessUserEnter,
		method : 'POST',
		headers : postheaders
	};

	var reqPost = http.request(options, function(res) {
		res.setEncoding('utf8');
		res.on('data', function(chunk) {
			// get Y and uid
			var chunkObj = JSON.parse(chunk);
			if (chunkObj.s === "Y") {
				callback(null, chunkObj);
			} else {
				callback("Unknown Error.", chunkObj);
			}
		});
	});

	reqPost.write(jsonObject);
	reqPost.end();
	reqPost.on('error', function(e) {
		console.log(e);
		callback("Unknown Error.");
	});
};


exports.getAppListByUID = function(uid, callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.appListByUID + uid,
		method : 'GET',
		headers : postheaders
	};

	var reqPost = http.request(options, function(res) {
		res.setEncoding('utf8');

		res.on('data', function(chunk) {
			console.log(chunk);
			
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