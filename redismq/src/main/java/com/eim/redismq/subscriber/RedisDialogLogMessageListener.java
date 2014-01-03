package com.eim.redismq.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.eim.persist.mapper.base.DialogLogMapper;
import com.eim.persist.po.base.DialogLogPO;
import com.eim.redismq.subscriber.mapper.DialogLogJSONMapper;

@Component
public class RedisDialogLogMessageListener implements MessageListener {
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private DialogLogMapper mapper;

	public void onMessage(final Message message, final byte[] pattern) {
		LOGGER.debug("Receive message " + message);

		DialogLogPO po = DialogLogJSONMapper.toObject(new String(message.getBody()));
		if (po != null) {
			mapper.insert(po);
		}
	}
}
