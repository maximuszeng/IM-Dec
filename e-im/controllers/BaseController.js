var _ = require("underscore");
var View = require("../views/Base");

module.exports = {
	name : "base",
	extend : function(child) {
		return _.extend({}, this, child);
	},
	run : function(req, res, next) {

	}
};
