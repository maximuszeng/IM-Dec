var AppRedisDao = require("../redis/AppRedisDao");
var AppAPI = require("../webapi/AppAPI");

// get APPID by appkey
exports.getAPPID = function(appkey, callback) {
	AppRedisDao.getAppIDByAppKey(appkey, function(err, result) {
		if (err || !result) {
			callback("appkey not exists.");
		} else {
			console.log("get appid by appkey " + appkey + " from redis, appid is " + result);
			callback(null, result);
		}
	});
};

// get app information by appid
exports.getAPPInfo = function(appid, callback) {
	AppRedisDao.getAPPInfoByAppID(appid, function(err, appinfo) {
		console.log(err);
		console.log(appinfo);
		if (err || !appinfo) {
			callback("appid not exists.");
		} else {
			console.log("get app information by appid " + appid + " from redis, appinfo is " + appinfo);
			callback(null, appinfo);
		}
	});
};

// when user enter
exports.enter = function(appid, headers, callback) {
	AppAPI.whenUserEnter(appid, {
		"aid" : appid,
		"ia" : headers.ip,
		"s" : headers.sessionID,
		"hal" : headers.acceptLang[0],
		"hua" : headers.userAgent,
		"hr" : headers.referrer
	}, callback);
};
