package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionMetadata;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(QuestionMetadata record);

    @Select({
        "select",
        "id, course_id, question_id, province_id, year_id, score_id, difficulty_type_id, ",
        "question_number, question_index, active",
        "from question_metadata",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionMetadataMapper.BaseResultMap")
    QuestionMetadata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionMetadata record);

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