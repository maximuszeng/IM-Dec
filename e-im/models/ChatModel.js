var config = require('../config')();
var keyModel = require("../models/KeyModel");
var UserRedisDao = require("../redis/UserRedisDao");
var AppRedisDao = require("../redis/AppRedisDao");

exports.staffIsReady = function(suid, uid, callback) {
	// if not cotains, add into
	UserRedisDao.getStaffInfoBySUID(suid, function(err, result) {
		if (err) {
			callback(err);
		} else if (result) {
			// get serve pool, and push into
			UserRedisDao.pushStaffToUseablePool(result, callback);
		}
	});
};

exports.staffIsServeEnd = function(suid, uid, callback) {
	// if not cotains, add into
	UserRedisDao.getStaffInfoBySUID(suid, function(err, result) {
		if (err) {
			callback(err);
		} else if (result) {
			UserRedisDao.popStaffToUseablePool(suid, uid, callback);
		}
	});
};

exports.chatwidgetGetAndHoldUseableSUID = function(appid, auid, callback) {
	// get staff info
	// get current appid's uid
	AppRedisDao.getUIDByAppID(appid, function (err, result){
		// get uid's serve pool
		if (!err) {
			var uid = result;
			UserRedisDao.getUserStaffUseablePool(uid, function(err1, result1){
				if (!err1) {
					// for each suid
					// TODO Equally distributed algorithms
					for(var i = 0, len = result1.length; i < len; i = i+1) {
						var suid = result1[i];
						UserRedisDao.getStaffInfoBySUID(suid, function(err2, result2) {
							if (result2) {
								var serviceConcurrentLimited = result2.serviceConcurrentLimited;
								UserRedisDao.getStaffCurrentServeScale(suid, function(err3, result3) {
									if (result3 < serviceConcurrentLimited) {
										UserRedisDao.pushAccessUserToStaff(suid, auid, function(err4) {
											if (!err4) {
												callback(null, suid);
											}
										});
									}
								});
							}
						});
					}
					callback('unknow error happened!');
				}
			});
		}
	});
	
};
