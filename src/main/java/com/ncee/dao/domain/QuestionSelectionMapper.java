package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionSelection;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QuestionSelectionMapper {
    @Delete({
        "delete from question_selection",
        "where question_selection_id = #{questionSelectionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long questionSelectionId);

    @Insert({
        "insert into question_selection (question_selection_id, question_id, ",
        "selection_index, selection, ",
        "active)",
        "values (#{questionSelectionId,jdbcType=BIGINT}, #{questionId,jdbcType=BIGINT}, ",
        "#{selectionIndex,jdbcType=VARCHAR}, #{selection,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(QuestionSelection record);

    @Select({
        "select",
        "question_selection_id, question_id, selection_index, selection, active",
        "from question_selection",
        "where question_selection_id = #{questionSelectionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="question_selection_id", property="questionSelectionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="selection_index", property="selectionIndex", jdbcType=JdbcType.VARCHAR),
        @Result(column="selection", property="selection", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionSelection selectByPrimaryKey(Long questionSelectionId);

    @Select({
        "select",
        "question_selection_id, question_id, selection_index, selection, active",
        "from question_selection",
        "order by id desc"
    })
    @Results({
        @Result(column="question_selection_id", property="questionSelectionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="selection_index", property="selectionIndex", jdbcType=JdbcType.VARCHAR),
        @Result(column="selection", property="selection", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionSelection> selectAll();

    @Update({
        "update question_selection",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "selection_index = #{selectionIndex,jdbcType=VARCHAR},",
          "selection = #{selection,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where question_selection_id = #{questionSelectionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionSelection record);
}