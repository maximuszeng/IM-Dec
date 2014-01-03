package com.eim.service.redis.base;

import static com.eim.service.redis.common.KeyConstants.SEQ_PREFIX;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.eim.persist.mapper.base.SequenceVerifierMapper;
import com.eim.persist.po.base.ApplicationPO;
import com.eim.persist.po.base.StaffPO;
import com.eim.persist.po.base.UserPO;
import com.eim.service.bo.base.AccessUserBO;

/**
 * Sequence Operator
 * 
 * @author maximus.zeng
 * 
 */
@Service
public class SequenceOperator {

	protected Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Resource(name = "redisTemplate")
	protected RedisTemplate<String, String> template;

	@Value("#{serviceConfig['redis.sequence.multilevelseparator']}")
	private String multiLevelSeparator;

	@Value("#{serviceConfig['redis.sequence.defaultincrement']}")
	private Integer defaultIncrement;

	@Autowired
	private SequenceVerifierMapper mapper;

	public String getMultiLevelName(String prefix, String subValue) {
		return prefix + multiLevelSeparator + subValue;
	}

	public String getKey(String name) {
		return SEQ_PREFIX + name;
	}

	public Long getNextId(String name) {
		return template.opsForValue().increment(getKey(name), 1);
	}

	public void loadAll() {
		ValueOperations<String, String> opsForValue = template.opsForValue();

		opsForValue.set(getKey(ApplicationPO.SEQUENCE_NAME), String.valueOf(mapper.getMaxAppId()));
		opsForValue.set(getKey(StaffPO.SEQUENCE_NAME), String.valueOf(mapper.getMaxSUID()));
		opsForValue.set(getKey(UserPO.SEQUENCE_NAME), String.valueOf(mapper.getMaxUID()));

		List<Map<String, Long>> maxAccessUsers = mapper.getMaxAccessUser();

		for (Map<String, Long> o : maxAccessUsers) {
			opsForValue.set(getKey(getMultiLevelName(AccessUserBO.SEQUENCE_NAME, o.get("id").toString())), o.get("auid")
					.toString());
		}
	}

	public void deleteOne(String name) {
		template.delete(getKey(name));
	}

	public void deleteAll() {
		template.delete(getPrefix() + "*");
	}

	public String getPrefix() {
		return SEQ_PREFIX;
	}
}
