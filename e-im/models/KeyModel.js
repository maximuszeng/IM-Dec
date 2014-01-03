exports.getAppIdKey = function(appkey) {
	return "ak:" + appkey;
};

exports.getAppInfoKey = function(appid) {
	return "app:" + appid;
};

//get login uid by username key
exports.getSUIDUserNameKey = function(name) {
	return "su:suid:un:" + name;
};

exports.getStaffPWDKey = function(suid) {
	return "su:pwd:" + suid;
};

//get login uid by email key
exports.getSUIDEMailKey = function(name) {
	return "su:suid:um:" + name;
};

exports.getUserInfoKey = function(uid) {
	return "u:" + uid;
};

exports.getStaffInfoKey = function(suid) {
	return "su:" + suid;
};

exports.getStaffServeAccessUserListKey = function(suid) {
	return "susl:" + suid;
};

exports.getUserServeStaffListKey = function(suid) {
	return "susl:" + suid;
};

exports.getStaffUseablePool = function(uid, appid) {
	return "sup:" + uid + ":" + appid;
};

exports.getUIDAppIdMapperKey = function(appid) {
	return "aum:" + appid;
};
