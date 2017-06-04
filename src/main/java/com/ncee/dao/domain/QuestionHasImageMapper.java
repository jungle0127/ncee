package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasImage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, question_id, question_image_id, active",
        "from question_has_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_image_id", property="questionImageId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionHasImage selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, question_id, question_image_id, active",
        "from question_has_image",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="question_image_id", property="questionImageId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionHasImage> selectAll();

    @Update({
        "update question_has_image",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "question_image_id = #{questionImageId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasImage record);
}