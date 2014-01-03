var config = require('../config')();
var redis = require("redis");

var redisClient = redis.createClient(config.redis.port, config.redis.host);
redisClient.select(config.redis.db);
