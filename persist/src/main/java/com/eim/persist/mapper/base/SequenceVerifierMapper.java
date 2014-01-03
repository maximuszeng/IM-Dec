package com.eim.persist.mapper.base;

import java.util.List;
import java.util.Map;

/**
 * Sequence Verifier Mapper
 * 
 * @author maximus.zeng
 * 
 */
public interface SequenceVerifierMapper {

	/**
	 * get max access user ids
	 * 
	 * @return
	 */
	List<Map<String, Long>> getMaxAccessUser();

	/**
	 * get max app id
	 * 
	 * @return
	 */
	Long getMaxAppId();

	/**
	 * get max staff uid
	 * 
	 * @return
	 */
	Long getMaxSUID();

	/**
	 * get max user id
	 * 
	 * @return
	 */
	Long getMaxUID();
}
