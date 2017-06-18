package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionImageMapper {
    @Delete({
        "delete from question_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_image (id, image_url, ",
        "image_description, active)",
        "values (#{id,jdbcType=BIGINT}, #{imageUrl,jdbcType=VARCHAR}, ",
        "#{imageDescription,jdbcType=VARCHAR}, #{active,jdbcType=INTEGER})"
    })
    int insert(QuestionImage record);

    int insertSelective(QuestionImage record);

    @Select({
        "select",
        "id, image_url, image_description, active",
        "from question_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionImageMapper.BaseResultMap")
    QuestionImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionImage record);

    @Update({
        "update question_image",
        "set image_url = #{imageUrl,jdbcType=VARCHAR},",
          "image_description = #{imageDescription,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionImage record);
}