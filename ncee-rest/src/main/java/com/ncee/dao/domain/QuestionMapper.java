package com.ncee.dao.domain;

import com.ncee.dao.model.Question;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "question_id, question, question_type_id, construct_type_id, answer, active, ",
        "analysis",
        "from question",
        "where question_id = #{questionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="question_type_id", property="questionTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="construct_type_id", property="constructTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR)
    })
    Question selectByPrimaryKey(Long questionId);

    @Select({
        "select",
        "question_id, question, question_type_id, construct_type_id, answer, active, ",
        "analysis",
        "from question",
        "order by id desc"
    })
    @Results({
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="question_type_id", property="questionTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="construct_type_id", property="constructTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Question> selectAll();

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
    int updateByPrimaryKey(Question record);
}