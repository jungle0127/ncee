package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionSelection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(QuestionSelection record);

    @Select({
        "select",
        "question_selection_id, question_id, selection_index, selection, active",
        "from question_selection",
        "where question_selection_id = #{questionSelectionId,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionSelectionMapper.BaseResultMap")
    QuestionSelection selectByPrimaryKey(Long questionSelectionId);

    int updateByPrimaryKeySelective(QuestionSelection record);

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