var config = {
	local : {
		mode : 'local',
		webport : 3000,
		redis : {
			host : "localhost",
			port : 6379,
			db : 2
		},
		webapi : {
			host : "localhost",
			port : 8080,
			path : {
				userregist : "/webapi/api/user/regist",
				accessUserEnter : "/webapi/api/au/enter",
				staffListByUID : "/webapi/api/staff/list/",
				appListByUID : "/webapi/api/app/list/",
				tag: {
					objectCategoryList : "/webapi/api/tag/oc/getAll",
					tagCategoryList : "/webapi/api/tag/tc/getAll",
					tagObjectRelationList : "/webapi/api/tag/tor/getAll",
					tagsList : "/webapi/api/tag/tags/getAll"
				}
			}
		}
	},
	staging : {
		mode : 'staging',
		webport : 4000,
		redis : {
			host : "localhost",
			port : 6379,
			db : 2
		},
		webapi : {
			host : "localhost",
			port : 8080,
			path : {
				userregist : "/webapi/api/user/regist",
				accessUserEnter : "/webapi/api/au/enter",
				staffListByUID : "/webapi/api/staff/list/",
				appListByUID : "/webapi/api/app/list/",
				tag: {
					objectCategoryList : "/webapi/api/tag/oc/getAll",
					tagCategoryList : "/webapi/api/tag/tc/getAll",
					tagObjectRelationList : "/webapi/api/tag/tor/getAll",
					tagsList : "/webapi/api/tag/tags/getAll"
				}
			}
		}
	},
	production : {
		mode : 'production',
		webport : 5000,
		redis : {
			host : "localhost",
			port : 6379,
			db : 2
		},
		webapi : {
			host : "localhost",
			port : 8080,
			path : {
				userregist : "/webapi/api/user/regist",
				accessUserEnter : "/webapi/api/au/enter",
				staffListByUID : "/webapi/api/staff/list/",
				appListByUID : "/webapi/api/app/list/",
				tag: {
					objectCategoryList : "/webapi/api/tag/oc/getAll",
					tagCategoryList : "/webapi/api/tag/tc/getAll",
					tagObjectRelationList : "/webapi/api/tag/tor/getAll",
					tagsList : "/webapi/api/tag/tags/getAll"
				}
			}
		}
	}
};

module.exports = function(mode) {
	return config[mode || process.argv[2] || 'local'] || config.local;
};