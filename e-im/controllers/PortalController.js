var BaseController = require("./BaseController");
var View = require("../views/Base");

module.exports = BaseController.extend({
	name : "Portal",
	index : function(req, res, next) {
		res.locals = {
			title : 'E-IM',
		};
		var v = new View(res, 'index');
		v.render({
			partials : {
				css : './items/css',
				script : './items/script',
			}
		});
	},
	portal : function(req, res, next) {
		res.locals = {
			title : 'E-IM',
		};
		var v = new View(res, 'portal');
		v.render();
	},
	portalviva : function(req, res, next) {
		res.locals = {
			title : 'E-IM',
		};
		var v = new View(res, 'portalviva');
		v.render();
	}
});
