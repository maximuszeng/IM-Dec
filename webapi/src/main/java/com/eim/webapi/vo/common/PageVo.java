/**
 * 
 */
package com.eim.webapi.vo.common;

import java.util.List;

/**
 * @author maximus.zeng
 * 
 */
public class PageVo<E> {
	private Long pageSize;
	private Long page;
	private Long totalCount;
	private List<E> contents;

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getContents() {
		return contents;
	}

	public void setContents(List<E> contents) {
		this.contents = contents;
	}

}
