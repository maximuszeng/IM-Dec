package com.eim.service.base;

public interface SequenceService {
	public Long getNextId(String name);

	public String getMultiLevelName(String prefix, String subValue);

}
