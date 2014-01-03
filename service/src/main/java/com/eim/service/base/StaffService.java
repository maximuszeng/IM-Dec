/**
 * 
 */
package com.eim.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eim.service.bo.base.StaffBO;

/**
 * @author maximus.zeng
 * 
 */
public interface StaffService {
	@Transactional
	public StaffBO newFreeStaff(StaffBO staff);

	@Transactional
	public StaffBO newFreeStaff(StaffBO staff, boolean checkUnique);

	public StaffBO load(Long suid);

	public List<StaffBO> loadAll();

	public List<StaffBO> getStaffListByUID(Long uid);

	@Transactional
	public void delete(Long suid);

	@Transactional
	public void deleteByUID(Long uid);

	@Transactional
	public void update(StaffBO staff);

	public void checkUserNameIsUnique(String staff);

	public void checkStaffQuantityIsNotExceeds(Long uid);

	public void checkEmailIsUnique(String email);
}