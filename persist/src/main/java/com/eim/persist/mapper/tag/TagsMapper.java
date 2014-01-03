/**
 * 
 */
package com.eim.persist.mapper.tag;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eim.persist.mapper.common.BaseMapper;
import com.eim.persist.po.tag.TagsPO;

/**
 * @author maximus.zeng
 * 
 */
public interface TagsMapper extends BaseMapper<TagsPO, Long> {
	void batchInsert(@Param("entities")List<? extends TagsPO> entities);
}
