package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, year_id, province_id, module_id, level_id, knowledge_id, active",
        "from knowledge_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge_id", property="knowledgeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    KnowledgeInfo selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, year_id, province_id, module_id, level_id, knowledge_id, active",
        "from knowledge_info",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT),
        @Result(column="level_id", property="levelId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge_id", property="knowledgeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<KnowledgeInfo> selectAll();

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