package com.ncee.dao.domain;

import com.ncee.dao.model.Knowledge;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, module_id, knowledge, description, active",
        "from knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge", property="knowledge", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Knowledge selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, module_id, knowledge, description, active",
        "from knowledge",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge", property="knowledge", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Knowledge> selectAll();

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