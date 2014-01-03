var config = require('../config')();
var KeyModel = require("../models/KeyModel");
var crypto = require("crypto");
var redis = require("redis");

var redisClient = redis.createClient(config.redis.port, config.redis.host);
redisClient.select(config.redis.db);

//return boolean
exports.pushStaffToUseablePool = function(staffBO, callback) {
	if (staffBO) {
		var uid = staffBO.uid;
		
		var staffUseablePoolKey = KeyModel.getStaffUseablePool(uid);
		redisClient.lpush(staffUseablePoolKey, suid, 0, function(err, result) {
			if (err) {
				console.log(err);
				callback(false);
			} else {
				callback(true);
			}
		});
	} else {
		callback("suid or uid is empty!");
	}
};

//return boolean
exports.popStaffToUseablePool = function(suid, uid, callback) {
	if (uid && suid) {
		var staffUseablePoolKey = KeyModel.getStaffUseablePool(uid);
		redisClient.hdel(staffUseablePoolKey, suid, function(err, result) {
			if (err) {
				console.log(err);
				callback(false);
			} else {
				callback(true);
			}
		});
	} else {
		callback("suid or uid is empty!");
	}
};

//return boolean
exports.isStaffInUseablePool = function(suid, uid, callback) {
	if (uid && suid) {
		var staffUseablePoolKey = KeyModel.getStaffUseablePool(uid);
		redisClient.hget(staffUseablePoolKey, suid, function(err, result) {
			if (err || !result) {
				console.log(err);
				callback(false);
			} else {
				callback(true);
			}
		});
	} else {
		callback("suid or uid is empty!");
	}
};

//return integer
exports.getStaffInUseablePoolScale = function(suid, uid, callback) {
	if (uid && suid) {
		var staffUseablePoolKey = KeyModel.getStaffUseablePool(uid);
		redisClient.hlen(staffUseablePoolKey, function(err, result) {
			if (err || !result) {
				console.log(err);
				callback(err);
			} else {
				callback(result);
			}
		});
	} else {
		callback("suid or uid is empty!");
	}
};