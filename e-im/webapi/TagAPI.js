var config = require('../config')();
var http = require("http");
var crypto = require("crypto");

exports.getObjectCategoryList = function(callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.tag.objectCategoryList,
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


exports.getTagCategoryList = function(callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.tag.tagCategoryList,
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


exports.getTagObjectRelationList = function(callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.tag.tagObjectRelationList,
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

exports.getTagsList = function(callback) {
	var postheaders = {
		'Content-Type' : 'application/json',
	};

	var options = {
		host : config.webapi.host,
		port : config.webapi.port,
		path : config.webapi.path.tag.tagsList,
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