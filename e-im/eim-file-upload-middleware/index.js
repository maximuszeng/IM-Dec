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

    return options;
}

module.exports = new EIMFileUploadMiddleware();