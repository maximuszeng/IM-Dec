package com.eim.persist.mapper.base;

import java.util.List;

import com.eim.persist.mapper.common.BaseMapper;
import com.eim.persist.po.base.ApplicationPO;

/**
 * Application Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface ApplicationMapper extends BaseMapper<ApplicationPO, Long> {

	/**
	 * Load applications by uid
	 * 
	 * @param uid
	 * @return
	 */
	List<ApplicationPO> loadByUID(Long uid);

	ApplicationPO loadByDomain(String domain);

	/**
	 * Load application ids by uid
	 * 
	 * @param uid
	 * @return
	 */
	List<Long> loadIDsByUID(Long uid);

	/**
	 * Delete applications by uid
	 * 
	 * @param uid
	 */
	void deleteByUID(Long uid);
}
