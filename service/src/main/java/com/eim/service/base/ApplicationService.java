/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.ApplicationBO;

/**
 * @author maximus.zeng
 * 
 */
public interface ApplicationService {
	@Transactional
	public ApplicationBO newApp(ApplicationBO application);

	List<Long> loadIDsByUID(Long uid);
	
	public List<ApplicationBO> getAppListByUID(Long uid);
	
	public ApplicationBO load(Long appId);

	public List<ApplicationBO> loadAll();
	
	@Transactional
	public void delete(Long appId);
	
	@Transactional
	public void update(ApplicationBO applicationBO);
}