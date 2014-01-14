var BaseController = require("../BaseController");
var _ = require("underscore");
var View = require("../../views/Base");
var fs = require("fs");
var TagAPI = require("../../webapi/TagAPI");

var _Partials = {
	css : './items/css',
	script : './items/script',
	topbar : './dashboard/management/items/topbar',
	sidebar : './dashboard/management/items/sidebar',
	header : './dashboard/management/items/header',
	footer : './dashboard/management/items/footer',
};

var _Layout = "dashboard/management/dashboard-layout";

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
			content : 'dashboard/management/dashboard'
		});

		v.render({
			partials : customPartials
		});
	},
	objectCategoryMgrGet : function(req, res) {

		TagAPI.getObjectCategoryList(function(contents) {
			res.locals = {
				title : 'Object Category Manager',
				contents : contents,
				uid : req.session.uid,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/management/tag/mgr-object-category",
				newObjectCategoryModal : "dashboard/management/tag/new-object-category"
			});

			v.render({
				partials : customPartials
			});

		});

	},
	tagCategoryMgrGet : function(req, res) {

		TagAPI.getTagCategoryList(function(contents) {
			res.locals = {
				title : 'Tag Category Manager',
				uid : req.session.uid,
				contents : contents,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/management/tag/mgr-tag-category"
			});

			v.render({
				partials : customPartials
			});
		});

	},
	tagObjectRelationMgrGet : function(req, res) {

		TagAPI.getTagObjectRelationList(function(contents) {
			res.locals = {
				title : 'Tag Object Relation Manager',
				uid : req.session.uid,
				contents : contents,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/management/tag/mgr-tag-object-relation"
			});

			v.render({
				partials : customPartials
			});
		});

	},
	tagsMgrGet : function(req, res) {

		TagAPI.getTagsList(function(contents) {
			res.locals = {
				title : 'Tags Manager',
				uid : req.session.uid,
				contents : contents,
				suid : req.session.suid,
				uname : req.session.uname
			};
			var v = new View(res, _Layout);

			var customPartials = _.extend(_Partials, {
				content : "dashboard/management/tag/mgr-tags"
			});

			v.render({
				partials : customPartials
			});
		});

	}

});
