/**
 * 
 */
package com.eim.webapi.vo.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eim.webapi.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author maximus.zeng
 * 
 */
@XmlRootElement(name = "l")
public class IPLocationVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 7969150840418111984L;
	private String ipAddress;
	private String address;
	private String addressSimple;
	private String addressDetail;
	private String nation;
	private String province;
	private String city;
	private String district;
	private String street;
	private String streetNumber;
	private String latitude;
	private String longitude;
	private String isp;

	@JsonProperty("n")
	public String getNation() {
		return nation;
	}

	@XmlElement(name = "n")
	public void setNation(String nation) {
		this.nation = nation;
	}

	@JsonProperty("c")
	public String getCity() {
		return city;
	}

	@XmlElement(name = "c")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("a")
	public String getAddress() {
		return address;
	}

	@XmlElement(name = "a")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("as")
	public String getAddressSimple() {
		return addressSimple;
	}

	@XmlElement(name = "as")
	public void setAddressSimple(String addressSimple) {
		this.addressSimple = addressSimple;
	}

	@JsonProperty("ad")
	public String getAddressDetail() {
		return addressDetail;
	}

	@XmlElement(name = "ad")
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@JsonProperty("p")
	public String getProvince() {
		return province;
	}

	@XmlElement(name = "p")
	public void setProvince(String province) {
		this.province = province;
	}

	@JsonProperty("d")
	public String getDistrict() {
		return district;
	}

	@XmlElement(name = "d")
	public void setDistrict(String district) {
		this.district = district;
	}

	@JsonProperty("s")
	public String getStreet() {
		return street;
	}

	@XmlElement(name = "s")
	public void setStreet(String street) {
		this.street = street;
	}

	@JsonProperty("sn")
	public String getStreetNumber() {
		return streetNumber;
	}

	@XmlElement(name = "sn")
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	@JsonProperty("lat")
	public String getLatitude() {
		return latitude;
	}

	@XmlElement(name = "lat")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("lon")
	public String getLongitude() {
		return longitude;
	}

	@XmlElement(name = "lon")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("ip")
	public String getIpAddress() {
		return ipAddress;
	}

	@XmlElement(name = "ip")
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@JsonProperty("isp")
	public String getIsp() {
		return isp;
	}

	@XmlElement(name = "isp")
	public void setIsp(String isp) {
		this.isp = isp;
	}

}
