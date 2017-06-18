package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeLevel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KnowledgeLevelMapper {
    @Delete({
        "delete from knowledge_level",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into knowledge_level (id, level, ",
        "description, active)",
        "values (#{id,jdbcType=BIGINT}, #{level,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{active,jdbcType=INTEGER})"
    })
    int insert(KnowledgeLevel record);

    int insertSelective(KnowledgeLevel record);

    @Select({
        "select",
        "id, level, description, active",
        "from knowledge_level",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.KnowledgeLevelMapper.BaseResultMap")
    KnowledgeLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeLevel record);

    @Update({
        "update knowledge_level",
        "set level = #{level,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(KnowledgeLevel record);
}