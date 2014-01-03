/**
 * 
 */
package com.eim.service.common;

/**
 * @author maximus.zeng
 * 
 */
public interface ErrorCodes {
	public static final String REGION_USER = "1000";
	public static final String REGION_STAFF = "1001";
	public static final String REGION_APP = "4000";
	public static final String REGION_ACCESSUSER = "2000";
	public static final String REGION_THIRDPARTY = "3000";

	public static final String USER_NOT_EXISTS_UID = REGION_USER + "01";
	public static final String USER_NOT_EXISTS_UNAME = REGION_USER + "02";
	public static final String USER_CONFLICT_USERNAME = REGION_STAFF + "02";
	public static final String USER_CONFLICT_EMAIL = REGION_STAFF + "03";
	
	public static final String STAFF_NOT_EXISTS_SUID = REGION_STAFF + "01";
	public static final String STAFF_CONFLICT_USERNAME = REGION_STAFF + "02";
	public static final String STAFF_CONFLICT_EMAIL = REGION_STAFF + "03";
	public static final String STAFF_LIMITED_QUANTITY_EXCEEDS = REGION_STAFF + "04";
	
	public static final String APP_CONFLICT_DOMAIN = REGION_APP + "01";
	public static final String APP_DOMAIN_NOT_REACHABLE = REGION_APP + "02";
	public static final String APP_DOMAIN_VALIDATE_FAILED = REGION_APP + "03";
	
	public static final String IPLOCATION_NOT_EXISTS = REGION_ACCESSUSER + "01";
	public static final String IPINTERPRETER_SERVICE_NOT_FOUND = REGION_THIRDPARTY + "01";
}
