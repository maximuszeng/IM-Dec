/**
 * 
 */
package com.eim.service.thirdparty.interpreter.ip.impl.baidu;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eim.service.bo.base.IPLocationBO;
import com.eim.service.common.ErrorCodes;
import com.eim.service.common.ServiceException;
import com.eim.service.thirdparty.interpreter.ip.IPInterpreterService;

/**
 * @author maximus.zeng
 * 
 */
@Service
public class BaiduIPInterpreterServiceImpl implements IPInterpreterService {
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Value("#{serviceConfig['ipinterpreter.baidu.urlpattern']}")
	private String urlPattern;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.thirdparty.interpreter.IPInterpreterService#translate()
	 */
	public IPLocationBO translate(String ip) {
		if (StringUtils.isBlank(ip)) {
			throw new ServiceException(ErrorCodes.IPLOCATION_NOT_EXISTS);
		}

		IPLocationBO bo = null;

		String actualURL = MessageFormat.format(urlPattern, ip);

		LOGGER.debug("Baidu url request is " + actualURL);

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(actualURL);

		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			bo = parseResultToBO(ip, EntityUtils.toString(response.getEntity()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return bo;
	}

	private IPLocationBO parseResultToBO(String ip, String jsonValue) {
		IPLocationBO result = null;
		try {
			JSONObject rootObj = new JSONObject(jsonValue);
			int status = rootObj.getInt("status");
			if (status == 0) {
				result = new IPLocationBO();
				result.setIpAddress(ip);
				result.setInsertDate(new Date().getTime());

				String address = rootObj.getString("address");
				if (StringUtils.isNotBlank(address)) {
					result.setAddress(address);
					String[] split = StringUtils.split(address, "|");
					if (split.length > 0) {
						result.setNation(split[0]);
					}
					if (split.length > 4) {
						result.setIsp(split[4]);
					}
				}

				JSONObject contentObj = rootObj.getJSONObject("content");
				if (contentObj != null) {
					result.setAddressSimple(contentObj.getString("address"));

					JSONObject addressDetailObj = contentObj.getJSONObject("address_detail");
					if (addressDetailObj != null) {
						result.setCity(addressDetailObj.getString("city"));
						result.setCityCode(addressDetailObj.getString("city_code"));
						result.setDistrict(addressDetailObj.getString("district"));
						result.setProvince(addressDetailObj.getString("province"));
						result.setStreet(addressDetailObj.getString("street"));
						result.setStreetNumber(addressDetailObj.getString("street_number"));

						result.setAddressDetail(result.getProvince() + result.getCity() + result.getDistrict()
								+ result.getStreet() + result.getStreetNumber());
					}
					JSONObject pointObj = contentObj.getJSONObject("point");
					if (pointObj != null) {
						result.setLongitude(pointObj.getString("x"));
						result.setLatitude(pointObj.getString("y"));
					}

				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			result = null;
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eim.service.thirdparty.interpreter.ip.IPInterpreterService#getName()
	 */
	public String getName() {
		return "BAIDU";
	}

}
