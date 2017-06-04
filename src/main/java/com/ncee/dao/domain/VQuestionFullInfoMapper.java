package com.ncee.dao.domain;

import com.ncee.dao.model.VQuestionFullInfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "question_id, exam_type_id, exam_type, province_id, province, year_id, year, ",
        "score_id, score, course_id, course, question_index, question_number, question_type_id, ",
        "question_type, difficulty_type_id, question_difficulty_type, question, book, ",
        "modulename, knowledge",
        "from v_question_full_info",
        "order by id desc"
    })
    @Results({
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="exam_type_id", property="examTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="exam_type", property="examType", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_id", property="scoreId", jdbcType=JdbcType.BIGINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="course", property="course", jdbcType=JdbcType.VARCHAR),
        @Result(column="question_index", property="questionIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="question_number", property="questionNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="question_type_id", property="questionTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_type", property="questionType", jdbcType=JdbcType.VARCHAR),
        @Result(column="difficulty_type_id", property="difficultyTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_difficulty_type", property="questionDifficultyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="book", property="book", jdbcType=JdbcType.VARCHAR),
        @Result(column="modulename", property="modulename", jdbcType=JdbcType.VARCHAR),
        @Result(column="knowledge", property="knowledge", jdbcType=JdbcType.VARCHAR)
    })
    List<VQuestionFullInfo> selectAll();
}