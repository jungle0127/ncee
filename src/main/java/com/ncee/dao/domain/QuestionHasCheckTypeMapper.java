package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasCheckType;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QuestionHasCheckTypeMapper {
    @Delete({
        "delete from question_has_check_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_has_check_type (id, question_id, ",
        "check_type_id, active)",
        "values (#{id,jdbcType=BIGINT}, #{questionId,jdbcType=BIGINT}, ",
        "#{checkTypeId,jdbcType=BIGINT}, #{active,jdbcType=INTEGER})"
    })
    int insert(QuestionHasCheckType record);

    @Select({
        "select",
        "id, question_id, check_type_id, active",
        "from question_has_check_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="check_type_id", property="checkTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionHasCheckType selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, question_id, check_type_id, active",
        "from question_has_check_type",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="check_type_id", property="checkTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionHasCheckType> selectAll();

    @Update({
        "update question_has_check_type",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "check_type_id = #{checkTypeId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasCheckType record);
}