package com.ncee.dao.domain;

import com.ncee.dao.model.Subquestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(Subquestion record);

    @Select({
        "select",
        "id, subquestion, question_id, score_id, sqindex, active",
        "from subquestion",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.SubquestionMapper.BaseResultMap")
    Subquestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subquestion record);

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