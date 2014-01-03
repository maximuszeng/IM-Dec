/**
 * 
 */
package com.eim.persist.po.base;

import java.io.Serializable;

import com.eim.persist.po.common.BasePO;

/**
 * @author maximus.zeng
 * 
 */
@SuppressWarnings("serial")
public class IPLocationPO extends BasePO implements Serializable {
	private String ipAddress;
	private String address;
	private String addressSimple;
	private String addressDetail;
	private String nation;
	private String province;
	private String city;
	private String cityCode;
	private String district;
	private String street;
	private String streetNumber;
	private String latitude;
	private String longitude;
	private String isp;
	private Long insertDate;
	
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Long getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Long insertDate) {
		this.insertDate = insertDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressSimple() {
		return addressSimple;
	}

	public void setAddressSimple(String addressSimple) {
		this.addressSimple = addressSimple;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

}
