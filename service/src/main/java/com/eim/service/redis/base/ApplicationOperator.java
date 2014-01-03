package com.eim.service.redis.base;

import static com.eim.service.redis.common.KeyConstants.APPLICATION_PREFIX;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PREFIX_KEY_APPID_UID_MAPPER;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PREFIX_KEY_ID_MAPPER;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_APPKEY;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_APPTYPE;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_CREATETIME;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_DOMAIN;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_INDUSTRYCATEGORY;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_LASTUPDATETIME;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_LOGOURL;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_NAME;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_UID;
import static com.eim.service.redis.common.KeyConstants.APPLICATION_PROPERTY_WELCOMEMESSAGE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.eim.service.base.ApplicationService;
import com.eim.service.bo.base.ApplicationBO;
import com.eim.service.redis.common.AbstractOperator;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class ApplicationOperator extends AbstractOperator<ApplicationBO> {
	@Autowired
	private ApplicationService applicationService;

	public String getKey(ApplicationBO app) {
		return APPLICATION_PREFIX + app.getAppId();
	}

	protected void addOneInternal(HashOperations<String, String, String> opsForHash,
			ValueOperations<String, String> opsForValue, ApplicationBO app) {
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_APPKEY, "" + app.getAppKey());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_APPTYPE, app.getAppType().name());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_DOMAIN, "" + app.getDomain());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_LOGOURL, "" + app.getLogoUrl());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_WELCOMEMESSAGE, "" + app.getWelcomeMessage());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_CREATETIME, "" + app.getCreateTime());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_LASTUPDATETIME, "" + app.getLastUpdateTime());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_UID, "" + app.getUid());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_NAME, "" + app.getName());
		addHashValue(opsForHash, getKey(app), APPLICATION_PROPERTY_INDUSTRYCATEGORY, "" + app.getIndustryCategory());

		addStringValue(opsForValue, APPLICATION_PREFIX_KEY_ID_MAPPER + app.getAppKey(), String.valueOf(app.getAppId()));
		addStringValue(opsForValue, APPLICATION_PREFIX_KEY_APPID_UID_MAPPER + app.getAppId(), String.valueOf(app.getUid()));
	}

	public void addAll() {
		List<ApplicationBO> apps = applicationService.loadAll();
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		ValueOperations<String, String> opsForValue = template.opsForValue();

		for (ApplicationBO app : apps) {
			addOneInternal(opsForHash, opsForValue, app);
		}
	}

	public void deleteOne(ApplicationBO entity) {
		super.deleteOne(entity);
		template.delete(APPLICATION_PREFIX_KEY_ID_MAPPER + entity.getAppKey());
	}

	public void addOne(ApplicationBO app) {
		HashOperations<String, String, String> opsForHash = template.opsForHash();
		ValueOperations<String, String> opsForValue = template.opsForValue();
		addOneInternal(opsForHash, opsForValue, app);
	}

	public String getPrefix() {
		return APPLICATION_PREFIX;
	}

	public void deleteAll() {
		super.deleteAll();
		super.deleteAll(APPLICATION_PREFIX_KEY_ID_MAPPER);
	}
}
