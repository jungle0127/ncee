package com.ncee.dao.domain;

import com.ncee.dao.model.Subquestion;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SubquestionMapper {
    @Delete({
        "delete from subquestion",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into subquestion (id, subquestion, ",
        "question_id, score_id, ",
        "sqindex, active)",
        "values (#{id,jdbcType=BIGINT}, #{subquestion,jdbcType=VARCHAR}, ",
        "#{questionId,jdbcType=BIGINT}, #{scoreId,jdbcType=BIGINT}, ",
        "#{sqindex,jdbcType=INTEGER}, #{active,jdbcType=INTEGER})"
    })
    int insert(Subquestion record);

    @Select({
        "select",
        "id, subquestion, question_id, score_id, sqindex, active",
        "from subquestion",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="subquestion", property="subquestion", jdbcType=JdbcType.VARCHAR),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="score_id", property="scoreId", jdbcType=JdbcType.BIGINT),
        @Result(column="sqindex", property="sqindex", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Subquestion selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, subquestion, question_id, score_id, sqindex, active",
        "from subquestion",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="subquestion", property="subquestion", jdbcType=JdbcType.VARCHAR),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="score_id", property="scoreId", jdbcType=JdbcType.BIGINT),
        @Result(column="sqindex", property="sqindex", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Subquestion> selectAll();

    @Update({
        "update subquestion",
        "set subquestion = #{subquestion,jdbcType=VARCHAR},",
          "question_id = #{questionId,jdbcType=BIGINT},",
          "score_id = #{scoreId,jdbcType=BIGINT},",
          "sqindex = #{sqindex,jdbcType=INTEGER},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Subquestion record);
}