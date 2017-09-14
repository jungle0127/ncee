package com.ncee.dao.domain;

import com.ncee.dao.model.VQuestionBasicInfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface VQuestionBasicInfoMapper {
    @Insert({
        "insert into v_question_basic_info (question_id, course_id, ",
        "course, province_id, ",
        "province, year_id, ",
        "year, question)",
        "values (#{questionId,jdbcType=BIGINT}, #{courseId,jdbcType=BIGINT}, ",
        "#{course,jdbcType=VARCHAR}, #{provinceId,jdbcType=BIGINT}, ",
        "#{province,jdbcType=VARCHAR}, #{yearId,jdbcType=BIGINT}, ",
        "#{year,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR})"
    })
    int insert(VQuestionBasicInfo record);

    @Select({
        "select",
        "question_id, course_id, course, province_id, province, year_id, year, question",
        "from v_question_basic_info",
        "order by id desc"
    })
    @Results({
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="course", property="course", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_id", property="provinceId", jdbcType=JdbcType.BIGINT),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="year_id", property="yearId", jdbcType=JdbcType.BIGINT),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR)
    })
    List<VQuestionBasicInfo> selectAll();
}