package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(QuestionType record);

    @Select({
        "select",
        "id, type, active",
        "from question_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionTypeMapper.BaseResultMap")
    QuestionType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionType record);

    @Update({
        "update question_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionType record);
}