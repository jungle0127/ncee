package com.ncee.dao.domain;

import com.ncee.dao.model.VQuestionBasicInfo;
import org.apache.ibatis.annotations.Insert;

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

    int insertSelective(VQuestionBasicInfo record);
}