/**
 * 
 */
package com.eim.service.redis.common;

/**
 * @author maximus.zeng
 * 
 */
public interface TagConstants {
	public static final String APPLICATION_PREFIX = "app:";
	public static final String APPLICATION_PREFIX_KEY_ID_MAPPER = "ak:";
	public static final String APPLICATION_PREFIX_KEY_APPID_UID_MAPPER = "aum:";
	
	public static final String APPLICATION_PROPERTY_APPKEY = "ak";
	public static final String APPLICATION_PROPERTY_APPTYPE = "at";
	public static final String APPLICATION_PROPERTY_DOMAIN = "d";
	public static final String APPLICATION_PROPERTY_LOGOURL = "lu";
	public static final String APPLICATION_PROPERTY_WELCOMEMESSAGE = "wm";
	public static final String APPLICATION_PROPERTY_CREATETIME = "ct";
	public static final String APPLICATION_PROPERTY_LASTUPDATETIME = "lut";
	public static final String APPLICATION_PROPERTY_UID = "uid";
	public static final String APPLICATION_PROPERTY_NAME = "n";
	public static final String APPLICATION_PROPERTY_INDUSTRYCATEGORY = "ic";
	
	public static final String STAFF_PREFIX = "su:";
	public static final String STAFF_APPIDS_PREFIX = "su:appids:";
	public static final String STAFF_PREFIX_GET_SUID_BY_USERNAME = "su:suid:un:";
	public static final String STAFF_PREFIX_GET_SUID_BY_EMAIL = "su:suid:um:";
	public static final String STAFF_PREFIX_GET_PWD_BY_EMAIL = "su:pwd:";

	public static final String STAFF_PROPERTY_USERNAME = "un";
	public static final String STAFF_PROPERTY_EMAIL = "ue";
	public static final String STAFF_PROPERTY_LASTACTIVEDATE = "lad";
	public static final String STAFF_PROPERTY_UID = "uid";
	public static final String STAFF_PROPERTY_CANSERVE = "cs";
	public static final String STAFF_PROPERTY_SUID = "suid";
	public static final String STAFF_PROPERTY_ISADMIN = "isa";
	public static final String STAFF_PROPERTY_SERVICEMODE = "sm";
	public static final String STAFF_PROPERTY_SERVICECONCURRENTLIMITED = "scl";
	
	public static final String USER_PREFIX = "u:";

	public static final String USER_PROPERTY_UID = "uid";
	public static final String USER_PROPERTY_LOGOURL = "lu";
	public static final String USER_PROPERTY_USERTYPE = "ut";
	public static final String USER_PROPERTY_CREATEDATE = "ct";
	public static final String USER_PROPERTY_STAFFLIMITED = "sl";
	public static final String USER_PROPERTY_STAFFUSED = "su";
	public static final String USER_PROPERTY_SERVICEMODE = "sm";
	public static final String USER_PROPERTY_SERVICECONCURRENTLIMITED = "scl";

}
