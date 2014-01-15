var _ = require('lodash'),
    fs = require('fs'),
    path = require('path'),
    mkdirp = require('mkdirp');

module.exports = function (middleware, options) {
    var FileManagerExt = function (req, res, callback)  {
    	this.req = req;
        this.res = res;
        this.callback = callback;
    };

    FileManagerExt.prototype.newFolder = function (newFolderPath) {
    	console.log(options.uploadDir());
    	var newFolderFullPath = options.uploadDir() + newFolderPath;
    	console.log(newFolderFullPath);
    	if (fs.existsSync(newFolderFullPath)) {
    		this.res.end('N');
    	} else {
    		fs.mkdirSync(newFolderFullPath);
    		this.res.end('Y');
    	}
    };

    return function (actioncode, options, req, res, next) {
    	var ext = new FileManagerExt(req, res, next);
    	if (actioncode === 'NF') {
    		ext.newFolder(options.newFolderPath);
    	}
    	
    }
};

