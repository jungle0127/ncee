package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionImage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, image_url, image_description, active",
        "from question_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="image_url", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_description", property="imageDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionImage selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, image_url, image_description, active",
        "from question_image",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="image_url", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_description", property="imageDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionImage> selectAll();

    @Update({
        "update question_image",
        "set image_url = #{imageUrl,jdbcType=VARCHAR},",
          "image_description = #{imageDescription,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionImage record);
}