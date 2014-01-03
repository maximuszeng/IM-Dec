/**
 * 
 */
package com.eim.service.redis.base;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.eim.service.CommonJunitSpringTest;
import com.eim.service.redis.common.RedisOperator;

/**
 * @author maximus.zeng
 * 
 */
public class OperatorTest extends CommonJunitSpringTest {
	@Autowired
	private Set<RedisOperator<?>> operators;

	@Autowired
	protected RedisTemplate<String, String> template;

	@Test
	public void testDoIt() {
		for (RedisOperator<?> o : operators) {
			o.addAll();
		}

		HashOperations<String, String, String> opsForHash = template.opsForHash();

		Map<String, String> entries = opsForHash.entries("u:maximus.zeng0");
		Iterator<String> iterator = entries.keySet().iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			String string = entries.get(next);

			System.out.println(next + "=" + string);
		}

		opsForHash.get("su:jacky1", "uid");

	}
}
