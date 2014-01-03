var config = require('../config')();
var KeyModel = require("../models/KeyModel");
var redis = require("redis");

var redisClient = redis.createClient(config.redis.port, config.redis.host);
redisClient.select(config.redis.db);

exports.getAppIDByAppKey = function(appkey, callback) {
	redisClient.get(KeyModel.getAppIdKey(appkey), function(err, result) {
		callback(err, result);
	});
};

exports.getAPPInfoByAppID = function(appID, callback) {
	redisClient.hgetall(KeyModel.getAppInfoKey(appID), function(err, result) {
		callback(err, result);
	});
};

exports.getUIDByAppID = function(appID, callback) {
	redisClient.get(KeyModel.getUIDAppIdMapperKey(appID), function(err, result) {
		callback(err, result);
	});
};
