var _ = require('lodash'),
    EventEmitter = require('events').EventEmitter;

var EIMFileUploadMiddleware = function () {
    EventEmitter.call(this);
    this.options = this.prepareOptions({});
};

require('util').inherits(EIMFileUploadMiddleware, EventEmitter);

EIMFileUploadMiddleware.prototype.prepareOptions = function (options) {
	// extend default configuration with custom configuration
    options = _.extend({
        tmpDir: '/tmp',
        uploadDir: __dirname + '/public/files',
        uploadUrl: '/files/',
        maxPostSize: 11000000000, // 11 GB
        minFileSize: 1,
        maxFileSize: 10000000000, // 10 GB
        acceptFileTypes: /.+/i,
        imageTypes: /\.(gif|jpe?g|png)$/i,
        imageVersions: {
        },
        accessControl: {
            allowOrigin: '*',
            allowMethods: 'OPTIONS, HEAD, GET, POST, PUT, DELETE'
        }
    }, options);

    _.each(['uploadDir', 'uploadUrl'], function (key) {
        if (!_.isFunction(options[key])) {
            var originalValue = options[key];
            options[key] = function () {
                return originalValue
            };
        }
    });

    return options;
}

EIMFileUploadMiddleware.prototype.configure = function (options) {
    this.options = this.prepareOptions(options);
};

EIMFileUploadMiddleware.prototype.fileHandler = function (options) {
    return require('./lib/filehandler')(this, this.prepareOptions(_.extend(this.options, options)));
};

EIMFileUploadMiddleware.prototype.fileManager = function (options) {
    return require('./lib/filemanager')(this, this.prepareOptions(_.extend(this.options, options)));
};

EIMFileUploadMiddleware.prototype.fileManagerext = function (options) {
    return require('./lib/filemanagerext')(this, this.prepareOptions(_.extend(this.options, options)));
};

module.exports = new EIMFileUploadMiddleware();
