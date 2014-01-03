var BaseController = require("../BaseController");
var _ = require("underscore");
var View = require("../../views/Base");
var crypto = require("crypto");
var fs = require("fs");

var _Partials = {
	css : './items/css',
	script : './items/script',
	topbar : './dashboard/template/items/topbar',
	sidebar : './dashboard/template/items/sidebar',
	header : './dashboard/template/items/header',
	footer : './dashboard/template/items/footer',
};

var _Layout = "dashboard/template/dashboard-layout";

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
			content : 'dashboard/template/dashboard'
		});

		v.render({
			partials : customPartials
		});
	},
	profile : function(req, res) {
		res.locals = {
			title : 'Profile',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-profile"
		});

		v.render({
			partials : customPartials
		});
	},
	invoice : function(req, res) {
		res.locals = {
			title : 'Invoice',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-invoice"
		});

		v.render({
			partials : customPartials
		});
	},
	pricing : function(req, res) {
		res.locals = {
			title : 'Pricing',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};

		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-pricing"
		});

		v.render({
			partials : customPartials
		});
	},
	support : function(req, res) {
		res.locals = {
			title : 'Support',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-support"
		});

		v.render({
			partials : customPartials
		});
	},
	gallery : function(req, res) {
		res.locals = {
			title : 'Gallery',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-gallery"
		});

		v.render({
			partials : customPartials
		});
	},
	settings : function(req, res) {
		res.locals = {
			title : 'Settings',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-settings"
		});

		v.render({
			partials : customPartials
		});
	},
	calendar : function(req, res) {
		res.locals = {
			title : 'Calendar',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-calendar"
		});

		v.render({
			partials : customPartials
		});
	},
	regular : function(req, res) {
		res.locals = {
			title : 'Regular',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};

		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/form-regular"
		});

		v.render({
			partials : customPartials
		});
	},
	extended : function(req, res) {
		res.locals = {
			title : 'Extended',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/form-extended"
		});

		v.render({
			partials : customPartials
		});
	},
	validation : function(req, res) {
		res.locals = {
			title : 'Validation',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/form-validation"
		});

		v.render({
			partials : customPartials
		});
	},
	buttons : function(req, res) {
		res.locals = {
			title : 'Buttons',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-buttons"
		});

		v.render({
			partials : customPartials
		});
	},
	icons : function(req, res) {
		res.locals = {
			title : 'Icons',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-icons"
		});

		v.render({
			partials : customPartials
		});
	},
	popups : function(req, res) {
		res.locals = {
			title : 'popups',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-popups"
		});

		v.render({
			partials : customPartials
		});
	},
	sliders : function(req, res) {
		res.locals = {
			title : 'sliders',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-sliders"
		});

		v.render({
			partials : customPartials
		});
	},
	tabs : function(req, res) {
		res.locals = {
			title : 'tabs',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-tabs"
		});

		v.render({
			partials : customPartials
		});
	},
	typography : function(req, res) {
		res.locals = {
			title : 'typography',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-typography"
		});

		v.render({
			partials : customPartials
		});
	},
	tablebasic : function(req, res) {
		res.locals = {
			title : 'tablebasic',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/table-basic"
		});

		v.render({
			partials : customPartials
		});
	},
	tableadvanced : function(req, res) {
		res.locals = {
			title : 'table-advanced',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/table-advanced"
		});

		v.render({
			partials : customPartials
		});
	},
	tableresponsive : function(req, res) {
		res.locals = {
			title : 'table-responsive',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/table-responsive"
		});

		v.render({
			partials : customPartials
		});
	},
	portlets : function(req, res) {
		res.locals = {
			title : 'ui-portlets',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/ui-portlets"
		});

		v.render({
			partials : customPartials
		});
	},
	chartflot : function(req, res) {
		res.locals = {
			title : 'chart-flot',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/chart-flot",
			customscripts : "dashboard/template/chart-flot-scripts"
		});

		v.render({
			partials : customPartials
		});
	},
	chartmorris : function(req, res) {
		res.locals = {
			title : 'chart-morris',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/chart-morris",
			customscripts : "dashboard/template/chart-morris-scripts"
		});

		v.render({
			partials : customPartials
		});
	},
	pagelogin : function(req, res) {
		res.locals = {
			title : 'page-login',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, "dashboard/template/page-login");
		v.render();
	},
	pageloginsocial : function(req, res) {
		res.locals = {
			title : 'page-login-social',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, "dashboard/template/page-login-social");
		v.render();
	},
	p404 : function(req, res) {
		res.locals = {
			title : 'Page not found!',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-404"
		});

		v.render({
			partials : customPartials
		});
	},
	p500 : function(req, res) {
		res.locals = {
			title : 'Page not found! 500',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-500"
		});

		v.render({
			partials : customPartials
		});
	},
	blank : function(req, res) {
		res.locals = {
			title : 'blank',
			uid : req.session.uid,
			suid : req.session.suid,
			uname : req.session.uname
		};
		var v = new View(res, _Layout);

		var customPartials = _.extend(_Partials, {
			content : "dashboard/template/page-blank"
		});

		v.render({
			partials : customPartials
		});
	}
});
