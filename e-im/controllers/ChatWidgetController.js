var BaseController = require("./BaseController");
var View = require("../views/Base");
var _ = require("underscore");
var chatModel = require("../models/ChatModel");
var appModel = require("../models/AppModel");
var toolkit = require("../utils/URIToolkit");

var _Partials = {
	css : './items/css',
	script : './items/script'
};

module.exports = BaseController.extend({
	name : "ChatWidget",
	chatwidgetForAccessUser : function(req, res, next) {
		var appkey = req.params.appkey;
		// step1: convert appkey to appid
		if (appkey) {
			appModel.getAPPID(appkey, function(err, appid) {
				if (err || !appid) {
					res.end("appid not found!");
				} else if (appid) {
					appModel.getAPPInfo(appid, function(err, appinfo) {
						if (err || !appinfo) {
							res.end("appinfo not found!");
						} else if (appinfo) {
							var domain = appinfo['d'];
							// verify the domain
							var referrer = req.header('Referrer');
							var hostConfig = toolkit.parseUri(domain).host;
							var hostActual = toolkit.parseUri(referrer).host;
							
//							if (hostConfig == hostActual) {
								// if domain verify success, show the connecting page.
								var logoURL = "UNKNOWN";
								if (appinfo['lu']) {
									logoURL = appinfo['lu'];
								}

								var welcomeMSG = "Welcome to App";
								if (appinfo['wm']) {
									welcomeMSG = appinfo['wm'];
								}

								var appType = appinfo['at'];
								
								var headers = {
									ip : req.ip,
									sessionID : req.sessionID,
									acceptLang:req.acceptedLanguages,
									userAgent:req.headers['user-agent'],
									referrer:referrer
								};
								
								appModel.enter(appid, headers, function(err, result) {
									if (!err) {
										res.locals = {
												title : 'E-IM Online Customer Service',
												auid : result['id'],
												welcomeMessage : appinfo['wm'],
												appName : appinfo['n'],
												appid : appid,
												connecting : res.__('connecting')
											};

											var v = new View(res, 'serviceconnector');
											v.render({
												partials : _Partials
											});
									} else {
										res.end(err);
									}
								});
							/*} else {
								res.end("domain verify failed!");
							}*/
						} else {
							res.end("appinfo not found!");
						}
					});
				} else {
					res.end("appid not found!");
				}

			});
		} else {
			res.end("appkey not found!");
		}

		// http://expressjs.com/api.html#req.query
		// req.acceptedLanguages
		// req.ip,req.ips
		// req.headers['referer']

		// step3: show the chat window to access user(Not connected to staff).
		// step4: when the window loaded, auto connect through socket.io client
		// step5: get useable staff id from app useable staff pool, and remove
		// staff from useable staff pool
		// step6: if the serve ended, add staff to useable pool.
	},
	chatwidgetForStaff : function(req, res, next) {
		// req.ip,req.ips(for ourself to analyze)
		// step 1: staff to login in
		// step 2: click Standby to ready(mark this staff is useable, and make
		// it online)
		// step 3: when user it entry, send message to staff
		// step 4: when serve ended,
		// step 4: when serve ended, 
	},
	chatwidgetStaffIsStandBy : function(req, res, next) {
		// put current uid to, if login
		chatModel.staffIsReady(req.session.suid, req.session.uid, function(result) {
			if (result) {
				res.end("Y");
			} else {
				res.end("N");
			}
		});
	},
	chatwidgetStaffServeEnd : function(req, res, next) {
		// put current uid to, if login
		chatModel.staffIsServeEnd(req.session.suid, req.session.uid, function(result) {
			if (result) {
				res.end("Y");
			} else {
				res.end("N");
			}
		});
	},
	chat : function(req, res, next) {
		res.locals = {
			title : 'Chat',
		};
		var v = new View(res, 'chat');
		v.render({
			partials : _Partials
		});
	},
	chatwidgetGetUseableSUID : function(req, res, next) {
		chatModel.chatwidgetGetAndHoldUseableSUID(req.params.appid, req.params.auid, function(err, result) {
			if (!err) {
				res.end(result);
			} else {
				res.end("N");
			}
		});
	}
});
