package com.ncee.dao.domain;

import com.ncee.dao.model.Knowledge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KnowledgeMapper {
    @Delete({
        "delete from knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into knowledge (id, module_id, ",
        "knowledge, description, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{moduleId,jdbcType=BIGINT}, ",
        "#{knowledge,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    @Select({
        "select",
        "id, module_id, knowledge, description, active",
        "from knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.KnowledgeMapper.BaseResultMap")
    Knowledge selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Knowledge record);

    @Update({
        "update knowledge",
        "set module_id = #{moduleId,jdbcType=BIGINT},",
          "knowledge = #{knowledge,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Knowledge record);
}