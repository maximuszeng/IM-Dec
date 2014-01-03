package com.eim.redismq;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisSimpleTest extends CommonJunitSpringTest {

	// inject the actual template
	@Autowired
	protected RedisTemplate<String, String> template;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	protected ListOperations<String, String> listOps;

	public RedisSimpleTest() {

	}

	@Test
	public void testApp() {
		ValueOperations<String, String> valueOper = template.opsForValue();
		valueOper.set("u:u1", "aaa");
		valueOper.set("u:u2", "bbb");
		System.out.println(valueOper.get("u:u1"));
		System.out.println(valueOper.get("u:u2"));
	}

}
