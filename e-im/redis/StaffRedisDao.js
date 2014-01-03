var config = require('../config')();
var KeyModel = require("../models/KeyModel");
var crypto = require("crypto");
var redis = require("redis");

var redisClient = redis.createClient(config.redis.port, config.redis.host);
redisClient.select(config.redis.db);

// get staff user id by username or email
exports.getSUIDByUserNameOrEMail = function(userNameOrEMail, callback) {
	if (userNameOrEMail) {
		redisClient.get(KeyModel.getSUIDUserNameKey(userNameOrEMail), function(err, result) {
			console.log("get uid by user name " + userNameOrEMail + " from redis, uid is " + result);
			if (err) {
				callback("user not exists.");
			} else if (result) {
				callback(err, result);
			} else {
				console.log("throw email.");
				// try to use email
				if (userNameOrEMail.indexOf("@") > -1) {
					redisClient.get(KeyModel.getSUIDEMailKey(userNameOrEMail),
							function(err, result) {
								console.log("get uid by user email " + userNameOrEMail + " from redis, uid is " + result);
								callback(err, result);
							});
				} else {
					callback("user not exists.");
				}
			}
		});
	} else {
		callback("userName is empty!");

	}
};

// get staff password by suid
exports.getPWDBySUID = function(suid, callback) {
	if (suid) {
		redisClient.get(KeyModel.getStaffPWDKey(suid), function(err, result) {
			callback(err, result);
		});
	} else {
		callback("suid is empty!");
	}
};

//get staff information by suid
exports.getStaffInfoBySUID = function(suid, callback) {
	if (suid) {
		redisClient.hgetall(KeyModel.getStaffInfoKey(suid), function(err, result) {
			if (err || !result) {
				callback("Unknown Error Happen!");
			} else if (result){
				var bo = {};
				bo.uid = result['uid'];
				bo.canServe = result['cs'];
				bo.uname = result['un'];
				bo.isAdmin = result['isa'];
				bo.email = result['ue'];
				bo.lastActiveDate = result['lad'];
				bo.suid = result['suid'];
				bo.serviceConcurrentLimited = result['scl'];
				bo.serviceMode = result['sm'];
				callback(err, bo);
			}
		});
	} else {
		callback("suid is empty!");
	}
};

//get staff current serve scale
exports.getStaffCurrentServeScale = function(suid, callback) {
	if (suid) {
		var staffServeListKey = KeyModel.getStaffServeAccessUserListKey(suid);
		redisClient.hlen(staffServeListKey, function(err, result) {
			callback(err, result);
		});
	} else {
		callback("suid is empty!");
	}
};

// push access user to staff serve list
exports.pushAccessUserToStaff = function(suid, auid, callback) {
	if (suid && auid) {
		var staffServeListKey = KeyModel.getStaffServeAccessUserListKey(suid);
		redisClient.hset(staffServeListKey, auid, "true", function(err, result) {
			if (!err) {
				callback();
			} else {
				callback(err);
			}
		});
	} else {
		callback("suid or auid is empty!");
	}
};

//return boolean
exports.popAccessUserToStaff = function(suid, auid, callback) {
	if (suid && auid) {
		var staffServeListKey = KeyModel.getStaffServeAccessUserListKey(suid);
		redisClient.hdel(staffServeListKey, auid, function(err, result) {
			callback(err, result);
		});
	} else {
		callback("suid or auid is empty!");
	}
};

//return boolean
exports.getUserStaffUseablePool = function(uid, callback) {
	if (uid) {
		var staffUseablePoolKey = KeyModel.getStaffUseablePool(uid);
		redisClient.hkeys(staffUseablePoolKey, function(err, result) {
			callback(err, result);
		});
	} else {
		callback("suid or uid is empty!");
	}
};
