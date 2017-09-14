package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionType;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QuestionTypeMapper {
    @Delete({
        "delete from question_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_type (id, type, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(QuestionType record);

    @Select({
        "select",
        "id, type, active",
        "from question_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionType selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, type, active",
        "from question_type",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionType> selectAll();

    @Update({
        "update question_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionType record);
}