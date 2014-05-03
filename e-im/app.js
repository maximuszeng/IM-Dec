var express = require("express");
var config = require('./config')();
var http = require("http");
var app = express();
var RedisStore = require('connect-redis')(express);
var redis = require("redis");
var i18n = require("i18n");
var _ = require("underscore");
var port = config.webport;

var UserController = require('./controllers/UserController');
var PortalController = require('./controllers/PortalController');
var ChatWidgetController = require('./controllers/ChatWidgetController');

var TemplateDashboardController = require('./controllers/dashboard/TemplateDashboardController');
var AdminDashboardController = require('./controllers/dashboard/AdminDashboardController');
var StaffDashboardController = require('./controllers/dashboard/StaffDashboardController');
var ManagementDashboardController = require('./controllers/dashboard/ManagementDashboardController');

app.engine('html', require('hogan-express'));
app.set('view engine', 'html');
app.set('views', __dirname + '/templates');
app.enable('trust proxy');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(express.cookieParser('OCS'));
app.use(express.session({
	store : new RedisStore({
		host : config.redis.host,
		port : config.redis.port,
		db : 1
	}),
	secret : '1234567890QWERTY'
}));

i18n.configure({
	locales : [ 'zh_CN', 'en-US' ],
	directory : __dirname + '/locales',
	defaultLocale : 'zh_CN'
});

app.use(i18n.init);

app.use(function(req, res, next) {
	if(req.query.lang){
		i18n.setLocale(req.query.lang);
	}
	next();
});

app.use(function(req, res, next) {
	res.locals.__ = function() {
		return function(text, render) {
			return i18n.__.apply(req, arguments);
		};
	};
	next();
});

var URL_PATTERN_SIGNIN_NAMESPACE = ["/admin", "/staff"];

app.use(function(req, res, next) {
	var url = req.originalUrl;
	_.each(URL_PATTERN_SIGNIN_NAMESPACE, function(namespace) {
		if (url.indexOf(namespace) === 0 && !req.session.uid) {
	    	return res.redirect("/signin?redirect=" + encodeURI(url));
	    }
	});
    next();
});

// PortalController start

app.get('/', PortalController.index);

app.get('/portal', PortalController.portal);

app.get('/portalviva', PortalController.portalviva);

// PortalController end

// UserController start
app.get('/signin', UserController.signInGet);

app.get('/signup', UserController.signUpGet);

app.get('/widgets', UserController.widgets);

app.post('/signinpost', UserController.signin);

app.post('/signuppost', UserController.signup);

app.get('/logout', UserController.logout);

// UserController end

// ChatWidgetController start
app.get('/serve/:appkey', ChatWidgetController.chatwidgetForAccessUser);

app.post('/serve/gusu/:appid/:auid', ChatWidgetController.chatwidgetGetUseableSUID);

app.get('/staff/chatwidget/:appkey', ChatWidgetController.chatwidgetForStaff);

app.post('/staff/status/standby', ChatWidgetController.chatwidgetStaffIsStandBy);

app.post('/staff/status/serveend', ChatWidgetController.chatwidgetStaffServeEnd);

app.get('/chat', ChatWidgetController.chat);

// ChatWidgetController end

// AdminDashboardController start
app.get('/admin/dashboard', AdminDashboardController.dashboard);

app.get('/admin/staff/new', AdminDashboardController.newStaffGet);

app.get('/admin/staff/mgr', AdminDashboardController.mgrStaffGet);

app.get('/admin/app/new', AdminDashboardController.newAppGet);

app.get('/admin/app/mgr', AdminDashboardController.mgrAppGet);

// AdminDashboardController end

// StaffDashboardController start
app.get('/staff/dashboard', StaffDashboardController.dashboard);
// StaffDashboardController end

//StaffDashboardController start
app.get('/management/dashboard', ManagementDashboardController.dashboard);

app.get('/management/tag/objectCategoryMgr', ManagementDashboardController.objectCategoryMgrGet);
app.get('/management/tag/tagCategoryMgr', ManagementDashboardController.tagCategoryMgrGet);
app.get('/management/tag/tagObjectRealtionMgr', ManagementDashboardController.tagObjectRelationMgrGet);
app.get('/management/tag/tagsMgr', ManagementDashboardController.tagsMgrGet);
// StaffDashboardController end

// TemplateDashboardController start
app.get('/dashboard-template', TemplateDashboardController.dashboard);

app.get('/profile', TemplateDashboardController.profile);

app.get('/invoice', TemplateDashboardController.invoice);

app.get('/pricing', TemplateDashboardController.pricing);

app.get('/support', TemplateDashboardController.support);

app.get('/gallery', TemplateDashboardController.gallery);

app.get('/settings', TemplateDashboardController.settings);

app.get('/calendar', TemplateDashboardController.calendar);

app.get('/regular', TemplateDashboardController.regular);

app.get('/extended', TemplateDashboardController.extended);

app.get('/validation', TemplateDashboardController.validation);

app.get('/buttons', TemplateDashboardController.buttons);

app.get('/icons', TemplateDashboardController.icons);

app.get('/popups', TemplateDashboardController.popups);

app.get('/sliders', TemplateDashboardController.sliders);

app.get('/tabs', TemplateDashboardController.tabs);

app.get('/typography', TemplateDashboardController.typography);

app.get('/tablebasic', TemplateDashboardController.tablebasic);

app.get('/tableadvanced', TemplateDashboardController.tableadvanced);

app.get('/tableresponsive', TemplateDashboardController.tableresponsive);

app.get('/portlets', TemplateDashboardController.portlets);

app.get('/chartflot', TemplateDashboardController.chartflot);

app.get('/chartmorris', TemplateDashboardController.chartmorris);

app.get('/pagelogin', TemplateDashboardController.pagelogin);

app.get('/pageloginsocial', TemplateDashboardController.pageloginsocial);

app.get('/404', TemplateDashboardController.p404);

app.get('/500', TemplateDashboardController.p500);

app.get('/blank', TemplateDashboardController.blank);
// TemplateDashboardController end

app.use(app.router);
app.use(express.static(__dirname + '/public'));


var io = require('socket.io').listen(app.listen(port));

var clients = [];

io.sockets.on('connection', function(socket) {
	clients.push(socket.id);
	console.log("UE:Create Socket Id is " + socket.id);

	socket.emit('message', {
		message : 'welcome to the chat',
		uid : socket.id
	});

	socket.broadcast.emit('message', {
		message : socket.id + " entry!"
	});

	socket.on('send', function(data) {
		console.log("UE:Data.Message " + data.message);
		console.log("UE:Data.To " + data.to);
		data.from = socket.id;
		io.sockets.socket(data.to).emit("message", data);
	});

});

app.use(function(err, req, res, next) {
	console.error(err.stack);
	res.send(500, err.stack);
});

console.log("Listening on port " + port);
