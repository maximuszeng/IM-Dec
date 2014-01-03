/**
 * 
 */
package com.eim.redismq.subscriber.mapper;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.eim.persist.enums.ContentType;
import com.eim.persist.enums.DialogDirection;
import com.eim.persist.po.base.DialogLogPO;

/**
 * @author maximus.zeng
 * 
 */
public class DialogLogJSONMapper {

	public static DialogLogPO toObject(String json) {
		JSONObject rootObj;
		DialogLogPO po = null;
		try {
			rootObj = new JSONObject(json);
			po = new DialogLogPO();
			po.setAppId(rootObj.getLong("appId"));
			po.setSuid(rootObj.getLong("suid"));
			po.setAuid(rootObj.getLong("auid"));
			po.setCreateTime(rootObj.getLong("createTime"));
			po.setDirection(DialogDirection.valueOf(rootObj.getString("direction")));
			po.setContentType(ContentType.valueOf(rootObj.getString("contentType")));
			po.setContent(rootObj.getString("content"));
		} catch (JSONException e) {
			po = null;
		}
		return po;
	}

}
