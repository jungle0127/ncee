package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeLevel;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, level, description, active",
        "from knowledge_level",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    KnowledgeLevel selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, level, description, active",
        "from knowledge_level",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<KnowledgeLevel> selectAll();

    @Update({
        "update knowledge_level",
        "set level = #{level,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(KnowledgeLevel record);
}