/**
 * 
 */
package com.eim.webapi.vo.base.result;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.eim.webapi.vo.base.UserVO;

/**
 * @author maximus.zeng
 * 
 */
public class UserVOList {
	@JsonProperty("us")
	private List<UserVO> users = new ArrayList<UserVO>();

	public UserVOList() {
	}

	public UserVOList(List<UserVO> users) {
		this.users = users;
	}

	@XmlElement(name = "user")
	public List<UserVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}
}