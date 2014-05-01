var BaseController = require("../BaseController");
var _ = require("underscore");
var View = require("../../views/Base");
var fs = require("fs");
var StaffAPI = require("../../webapi/StaffAPI");
var AppAPI = require("../../webapi/AppAPI");

var _Partials = {
	css : './items/css',
	script : './items/script',
	topbar : './dashboard/admin/items/topbar',
	sidebar : './dashboard/admin/items/sidebar',
	header : './dashboard/admin/items/header',
	footer : './dashboard/admin/items/footer',
};

var _Layout = "dashboard/admin/dashboard-layout";

module.exports = BaseController.extend({
	name : "UserDashboard",
	dashboard : function(req, res) {
		res.locals = {
			title : 'Dashboard',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};

		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : 'dashboard/admin/dashboard'
		});

		v.render({
			partials : customPartials
		});
	},
	newStaffGet : function(req, res) {
		res.locals = {
			title : 'New Staff',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/admin/staff/new"
		});

		v.render({
			partials : customPartials
		});
	},
	mgrStaffGet : function(req, res) {
		var uid = req.session.uid;

		StaffAPI.getStaffListByUID(uid, function(contents) {
			res.locals = {
				contents : contents,
				title : 'Staff Manager',
				uid : req.session.uid,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/admin/staff/mgr"
			});

			v.render({
				partials : customPartials
			});
		});
	},
	newAppGet : function(req, res) {
		res.locals = {
			title : 'New Application',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/admin/app/new"
		});

		v.render({
			partials : customPartials
		});
	},
	mgrAppGet : function(req, res) {
		var uid = req.session.uid;
		AppAPI.getAppListByUID(uid, function(contents) {
			res.locals = {
				contents : contents,
				title : 'Application Manager',
				uid : req.session.uid,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/admin/app/mgr"
			});

			v.render({
				partials : customPartials
			});
		});
	}
});
