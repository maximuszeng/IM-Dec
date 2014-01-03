package com.eim.redismq;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class RedisPublisherSample {
	private final RedisTemplate<String, Object> template;
	private final ChannelTopic topic;

	public RedisPublisherSample(final RedisTemplate<String, Object> template, final ChannelTopic topic) {
		this.template = template;
		this.topic = topic;
	}

	public void publish(String message) {
		template.convertAndSend(topic.getTopic(), message);
	}
}
