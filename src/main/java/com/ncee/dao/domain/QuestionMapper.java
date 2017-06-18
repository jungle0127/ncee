package com.ncee.dao.domain;

import com.ncee.dao.model.Question;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionMapper {
    @Delete({
        "delete from question",
        "where question_id = #{questionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long questionId);

    @Insert({
        "insert into question (question_id, question, ",
        "question_type_id, construct_type_id, ",
        "answer, active, ",
        "analysis)",
        "values (#{questionId,jdbcType=BIGINT}, #{question,jdbcType=VARCHAR}, ",
        "#{questionTypeId,jdbcType=BIGINT}, #{constructTypeId,jdbcType=BIGINT}, ",
        "#{answer,jdbcType=VARCHAR}, #{active,jdbcType=INTEGER}, ",
        "#{analysis,jdbcType=LONGVARCHAR})"
    })
    int insert(Question record);

    int insertSelective(Question record);

    @Select({
        "select",
        "question_id, question, question_type_id, construct_type_id, answer, active, ",
        "analysis",
        "from question",
        "where question_id = #{questionId,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionMapper.ResultMapWithBLOBs")
    Question selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(Question record);

    @Update({
        "update question",
        "set question = #{question,jdbcType=VARCHAR},",
          "question_type_id = #{questionTypeId,jdbcType=BIGINT},",
          "construct_type_id = #{constructTypeId,jdbcType=BIGINT},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER},",
          "analysis = #{analysis,jdbcType=LONGVARCHAR}",
        "where question_id = #{questionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Question record);

    @Update({
        "update question",
        "set question = #{question,jdbcType=VARCHAR},",
          "question_type_id = #{questionTypeId,jdbcType=BIGINT},",
          "construct_type_id = #{constructTypeId,jdbcType=BIGINT},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where question_id = #{questionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Question record);
}