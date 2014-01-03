package com.eim.redismq;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisPubSubTest extends CommonJunitSpringTest {

	@Autowired
	private RedisPublisherSample publisher;

	@Before
	public void testBefore() {
	}

	@Test
	public void testApp() throws JsonGenerationException, JsonMappingException, IOException, InterruptedException {
		for (int i = 0; i < 100; i++) {
			String json = toJSON(i);
			Thread.currentThread().sleep(10);
			publisher.publish(json);
		}
	}

	public String toJSON(int i) throws JsonGenerationException, JsonMappingException, IOException {
		DialogLogVoSample sample = new DialogLogVoSample();
		sample.setAppId(1L);
		sample.setAuid(1L);
		sample.setContent("test" + i);
		sample.setCreateTime(new Date().getTime());
		sample.setDirection("RC");
		sample.setSuid(1L);
		sample.setContentType("text");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(sample);
		return json;

	}
}
