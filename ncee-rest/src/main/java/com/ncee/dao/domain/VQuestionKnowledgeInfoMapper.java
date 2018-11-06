package com.ncee.dao.domain;

import com.ncee.dao.model.VQuestionKnowledgeInfo;
import org.apache.ibatis.annotations.Insert;

public interface VQuestionKnowledgeInfoMapper {
    @Insert({
        "insert into v_question_knowledge_info (type, question, ",
        "course, book, knowledge)",
        "values (#{type,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR}, ",
        "#{course,jdbcType=VARCHAR}, #{book,jdbcType=VARCHAR}, #{knowledge,jdbcType=VARCHAR})"
    })
    int insert(VQuestionKnowledgeInfo record);

    int insertSelective(VQuestionKnowledgeInfo record);
}