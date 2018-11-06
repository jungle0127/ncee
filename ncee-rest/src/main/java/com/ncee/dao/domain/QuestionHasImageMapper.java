package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionHasImageMapper {
    @Delete({
        "delete from question_has_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_has_image (id, question_id, ",
        "question_image_id, active)",
        "values (#{id,jdbcType=BIGINT}, #{questionId,jdbcType=BIGINT}, ",
        "#{questionImageId,jdbcType=BIGINT}, #{active,jdbcType=INTEGER})"
    })
    int insert(QuestionHasImage record);

    int insertSelective(QuestionHasImage record);

    @Select({
        "select",
        "id, question_id, question_image_id, active",
        "from question_has_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionHasImageMapper.BaseResultMap")
    QuestionHasImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionHasImage record);

    @Update({
        "update question_has_image",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "question_image_id = #{questionImageId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasImage record);
}