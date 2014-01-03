/**
 * 
 */
package com.eim.webapi.vo.tag.result;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.eim.webapi.vo.tag.TagsVO;

/**
 * @author maximus.zeng
 * 
 */
public class TagsVOList {
	@JsonProperty("tags")
	private List<TagsVO> tags = new ArrayList<TagsVO>();

	public TagsVOList() {
	}

	public TagsVOList(List<TagsVO> users) {
		this.tags = users;
	}

	@XmlElement(name = "user")
	public List<TagsVO> getUsers() {
		return tags;
	}

	public void setUsers(List<TagsVO> users) {
		this.tags = users;
	}
}