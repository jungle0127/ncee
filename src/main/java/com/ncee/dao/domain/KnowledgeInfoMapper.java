package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KnowledgeInfoMapper {
    @Delete({
        "delete from knowledge_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into knowledge_info (id, year_id, ",
        "province_id, module_id, ",
        "level_id, knowledge_id, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{yearId,jdbcType=BIGINT}, ",
        "#{provinceId,jdbcType=BIGINT}, #{moduleId,jdbcType=BIGINT}, ",
        "#{levelId,jdbcType=BIGINT}, #{knowledgeId,jdbcType=BIGINT}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(KnowledgeInfo record);

    int insertSelective(KnowledgeInfo record);

    @Select({
        "select",
        "id, year_id, province_id, module_id, level_id, knowledge_id, active",
        "from knowledge_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.KnowledgeInfoMapper.BaseResultMap")
    KnowledgeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeInfo record);

    @Update({
        "update knowledge_info",
        "set year_id = #{yearId,jdbcType=BIGINT},",
          "province_id = #{provinceId,jdbcType=BIGINT},",
          "module_id = #{moduleId,jdbcType=BIGINT},",
          "level_id = #{levelId,jdbcType=BIGINT},",
          "knowledge_id = #{knowledgeId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(KnowledgeInfo record);
}