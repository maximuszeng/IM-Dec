var BaseController = require("./BaseController");
var View = require("../views/Base");
var _ = require("underscore");
var model = require("../models/UserModel");
var crypto = require("crypto");
var fs = require("fs");

var _Partials = {
	css : './items/css',
	script : './items/script'
};

function processLoginRedirect(req, res) {
	if (req.session.uid) {
		if (req.session.isAdmin) {
			res.redirect('/admin/dashboard');
		} else {
			res.redirect('/staff/dashboard');
		}
	}
}

module.exports = BaseController.extend({
	name : "User",
	signup : function(req, res, next) {
		var self = this;
		var signupPost = req.body;
		var name = signupPost.name;
		var email = signupPost.email;
		var password = signupPost.password;
		if (name !== '' && password !== '') {
			// check the username if exists(from redis)
			model.getSUID(name, function(err, result) {
				if (result) {
					// fire username unavailable
					res.end("user name not available");
				} else {
					console.log("user name available");
					model.signUp(name, email, password, function(err, result) {
						if (err) {
							res.end("user name not available");
						} else {
							res.end(result);
						}
					});
				}
			});
		}
	},
	signUpGet : function(req, res) {
		if (req.session.uid) {
			processLoginRedirect(req, res);
		} else {
			res.locals = {
				title : 'Signup',
			};
			var v = new View(res, 'signup');
			v.render({
				partials : _Partials
			});
		}
	},
	signin : function(req, res) {
		var post = req.body;
		if (post.name !== '' && post.password !== '') {
			var name = post.name;
			var password = post.password;
			model.signin(name, password, function(err, result) {
				if (err || !result) {
					res.end('UserName or Password Invalid.');
				} else if (result) {
					req.session.uid = result.uid;
					req.session.canServe = result.canServe;
					req.session.uname = result.uname;
					req.session.isAdmin = result.isAdmin;
					req.session.email = result.email;
					req.session.lastActiveDate = result.lastActiveDate;
					req.session.suid = result.suid;
					if (result.isAdmin) {
						res.end('A');
					} else {
						res.end('Y');
					}
				}
			});
		}
	},
	logout : function(req, res) {
		if (req.session.uid) {
			req.session.destroy(function() {
				res.redirect("/");
			});
		}
	},
	isSignIn : function(req) {
		return (req.session && req.session.uid);
	},
	signInGet : function(req, res) {
		if (req.session.uid) {
			processLoginRedirect(req, res);
		} else {
			var redirect = req.query.redirect;
			res.locals = {
				title : 'Signin',
				redirect : redirect
			};
			var v = new View(res, 'signin');
			v.render({
				partials : _Partials
			});
		}
	},
	widgets : function(req, res) {
		res.locals = {
			title : 'Dashboard',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, 'user/widgets');

		var customPartials = _.extend(_Partials, {
			navbar : './user/items/navbar',
			sidebar : './user/items/sidebar',
			head : './user/items/head',
		});

		v.render({
			partials : customPartials
		});
	}
});
