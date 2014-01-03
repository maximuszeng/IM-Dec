var crypto = require("crypto");
var config = require('../config')();
var UserRedisDao = require("../redis/UserRedisDao");
var StaffRedisDao = require("../redis/StaffRedisDao");

var UserAPI = require("../webapi/UserAPI");

// get UID by login name(username or email)
exports.getSUID = function(userName, callback) {
	StaffRedisDao.getSUIDByUserNameOrEMail(userName, callback);
};

exports.signin = function(name, password, callback) {
	// try to get uid
	StaffRedisDao.getSUIDByUserNameOrEMail(name, function(err, result) {
		if (result) {
			var suid = result;
			// try to get pwd
			StaffRedisDao.getPWDBySUID(suid, function(err, result) {
				if (err || !result) {
					callback('UserName or Password Invalid.');
				}
				var md5 = crypto.createHash('md5');
				var passwordCrypto = md5.update(password).digest('hex')
						.toUpperCase();
				if (passwordCrypto === result) {
					// try to get user required detail info and set to session
					StaffRedisDao.getStaffInfoBySUID(suid,
							function(err, result) {
								callback(err, result);
							});
				} else {
					callback('UserName or Password Invalid.');
				}
			});
		} else {
			callback('UserName or Password Invalid.');
		}
	});
};

exports.signUp = function(name, email, password, callback) {
	UserAPI.signUp(name, email, password, function(err, result) {
		if (err || !result) {
			callback(err);
		} else {
			if (result === 'Y') {
				callback(null, result);
			} else {
				callback(err);
			}
		}
	});
};
