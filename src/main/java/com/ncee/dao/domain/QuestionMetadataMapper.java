package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionMetadata;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QuestionMetadataMapper {
    @Delete({
        "delete from question_metadata",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_metadata (id, course_id, ",
        "question_id, province_id, ",
        "year_id, score_id, difficulty_type_id, ",
        "question_number, question_index, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{courseId,jdbcType=BIGINT}, ",
        "#{questionId,jdbcType=BIGINT}, #{provinceId,jdbcType=BIGINT}, ",
        "#{yearId,jdbcType=BIGINT}, #{scoreId,jdbcType=BIGINT}, #{difficultyTypeId,jdbcType=BIGINT}, ",
        "#{questionNumber,jdbcType=INTEGER}, #{questionIndex,jdbcType=INTEGER}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(QuestionMetadata record);

    @Select({
        "select",
        "id, course_id, question_id, province_id, year_id, score_id, difficulty_type_id, ",
        "question_number, question_index, active",
        "from question_metadata",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="score_id", property="scoreId", jdbcType=JdbcType.BIGINT),
        @Result(column="difficulty_type_id", property="difficultyTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_number", property="questionNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="question_index", property="questionIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionMetadata selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, course_id, question_id, province_id, year_id, score_id, difficulty_type_id, ",
        "question_number, question_index, active",
        "from question_metadata",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="score_id", property="scoreId", jdbcType=JdbcType.BIGINT),
        @Result(column="difficulty_type_id", property="difficultyTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_number", property="questionNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="question_index", property="questionIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionMetadata> selectAll();

    @Update({
        "update question_metadata",
        "set course_id = #{courseId,jdbcType=BIGINT},",
          "question_id = #{questionId,jdbcType=BIGINT},",
          "province_id = #{provinceId,jdbcType=BIGINT},",
          "year_id = #{yearId,jdbcType=BIGINT},",
          "score_id = #{scoreId,jdbcType=BIGINT},",
          "difficulty_type_id = #{difficultyTypeId,jdbcType=BIGINT},",
          "question_number = #{questionNumber,jdbcType=INTEGER},",
          "question_index = #{questionIndex,jdbcType=INTEGER},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionMetadata record);
}