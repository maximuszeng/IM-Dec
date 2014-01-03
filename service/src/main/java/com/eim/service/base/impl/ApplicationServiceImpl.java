package com.eim.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eim.persist.po.base.ApplicationPO;
import com.eim.service.base.ApplicationService;
import com.eim.service.bo.base.ApplicationBO;
import com.eim.service.common.BaseService;
import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;

@Service
public class ApplicationServiceImpl extends BaseService<ApplicationBO, ApplicationPO> implements ApplicationService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.service.impl.ApplicationService#insert(com.eim.redispro
	 * .persist.domain.ApplicationVo)
	 */
	@Transactional
	public ApplicationBO newApp(ApplicationBO app) {
		// domain is unique
		checkDomainIsUnique(app);

		Long nextId = sequenceService.getNextId(ApplicationPO.SEQUENCE_NAME);
		app.setAppKey(md5(nextId));
		app.setAppId(nextId);
		app.setCreateTime(new Date().getTime());
		applicationMapper.insert(app);
		applicationOperator.addOne(app);
		return app;
	}

	public void checkDomainIsUnique(ApplicationBO app) {
		// check domain
		ApplicationPO loadByDomain = applicationMapper.loadByDomain(app.getDomain());
		if (loadByDomain != null) {
			throw new ServiceException(ErrorCodes.APP_CONFLICT_DOMAIN, app.getDomain());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.redispro.service.impl.ApplicationService#load(java.lang.Long)
	 */
	public ApplicationBO load(Long appId) {
		return copyPOToBO(applicationMapper.load(appId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.ApplicationService#delete(java.lang.Long)
	 */
	@Transactional
	public void delete(Long appId) {
		dialogLogMapper.deleteByAppId(appId);
		accessUserMapper.deleteByAppId(appId);
		applicationMapper.delete(appId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.ApplicationService#update(com.eim.bo.ApplicationBO)
	 */
	@Transactional
	public void update(ApplicationBO app) {
		checkDomainIsUnique(app);
		app.setLastUpdateTime(new Date().getTime());
		applicationMapper.update(app);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.ApplicationService#loadAll()
	 */
	@Override
	public List<ApplicationBO> loadAll() {
		List<ApplicationPO> appPOs = applicationMapper.loadAll();

		List<ApplicationBO> appBOs = new ArrayList<ApplicationBO>();

		for (ApplicationPO appBO : appPOs) {
			appBOs.add(copyPOToBO(appBO));
		}
		return appBOs;
	}

	public List<Long> loadIDsByUID(Long uid) {
		return applicationMapper.loadIDsByUID(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eim.service.ApplicationService#getAppListByUID(java.lang.Long)
	 */
	public List<ApplicationBO> getAppListByUID(Long uid) {
		List<ApplicationPO> appPOs = applicationMapper.loadByUID(uid);

		List<ApplicationBO> appBOs = new ArrayList<ApplicationBO>();

		for (ApplicationPO appBO : appPOs) {
			appBOs.add(copyPOToBO(appBO));
		}
		return appBOs;
	}
}
