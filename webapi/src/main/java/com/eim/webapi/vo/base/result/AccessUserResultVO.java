/**
 * 
 */
package com.eim.webapi.vo.base.result;

import javax.xml.bind.annotation.XmlElement;

import com.eim.webapi.vo.base.IPLocationVO;
import com.eim.webapi.vo.common.ResultVO;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author maximus.zeng
 * 
 */
@SuppressWarnings("serial")
public class AccessUserResultVO extends ResultVO {
	private IPLocationVO ipLocationVO;

	@JsonProperty("ipv")
	public IPLocationVO getIpLocationVO() {
		return ipLocationVO;
	}

	@XmlElement(name = "ipv")
	public void setIpLocationVO(IPLocationVO ipLocationVO) {
		this.ipLocationVO = ipLocationVO;
	}

}
