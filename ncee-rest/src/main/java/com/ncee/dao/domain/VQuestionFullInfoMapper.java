package com.ncee.dao.domain;

import com.ncee.dao.model.VQuestionFullInfo;
import org.apache.ibatis.annotations.Insert;

public interface VQuestionFullInfoMapper {
    @Insert({
        "insert into v_question_full_info (question_id, exam_type_id, ",
        "exam_type, province_id, ",
        "province, year_id, ",
        "year, score_id, score, ",
        "course_id, course, ",
        "question_index, question_number, ",
        "question_type_id, question_type, ",
        "difficulty_type_id, question_difficulty_type, ",
        "question, book, ",
        "modulename, knowledge)",
        "values (#{questionId,jdbcType=BIGINT}, #{examTypeId,jdbcType=BIGINT}, ",
        "#{examType,jdbcType=VARCHAR}, #{provinceId,jdbcType=BIGINT}, ",
        "#{province,jdbcType=VARCHAR}, #{yearId,jdbcType=BIGINT}, ",
        "#{year,jdbcType=VARCHAR}, #{scoreId,jdbcType=BIGINT}, #{score,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=BIGINT}, #{course,jdbcType=VARCHAR}, ",
        "#{questionIndex,jdbcType=INTEGER}, #{questionNumber,jdbcType=INTEGER}, ",
        "#{questionTypeId,jdbcType=BIGINT}, #{questionType,jdbcType=VARCHAR}, ",
        "#{difficultyTypeId,jdbcType=BIGINT}, #{questionDifficultyType,jdbcType=VARCHAR}, ",
        "#{question,jdbcType=VARCHAR}, #{book,jdbcType=VARCHAR}, ",
        "#{modulename,jdbcType=VARCHAR}, #{knowledge,jdbcType=VARCHAR})"
    })
    int insert(VQuestionFullInfo record);

    int insertSelective(VQuestionFullInfo record);
}