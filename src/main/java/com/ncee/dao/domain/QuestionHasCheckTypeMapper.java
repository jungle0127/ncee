package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasCheckType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(QuestionHasCheckType record);

    @Select({
        "select",
        "id, question_id, check_type_id, active",
        "from question_has_check_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionHasCheckTypeMapper.BaseResultMap")
    QuestionHasCheckType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionHasCheckType record);

    @Update({
        "update question_has_check_type",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "check_type_id = #{checkTypeId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasCheckType record);
}