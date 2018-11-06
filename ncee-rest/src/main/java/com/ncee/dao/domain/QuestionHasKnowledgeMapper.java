package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasKnowledge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionHasKnowledgeMapper {
    @Delete({
        "delete from question_has_knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question_has_knowledge (id, question_id, ",
        "knowledge_id, active)",
        "values (#{id,jdbcType=BIGINT}, #{questionId,jdbcType=BIGINT}, ",
        "#{knowledgeId,jdbcType=BIGINT}, #{active,jdbcType=INTEGER})"
    })
    int insert(QuestionHasKnowledge record);

    int insertSelective(QuestionHasKnowledge record);

    @Select({
        "select",
        "id, question_id, knowledge_id, active",
        "from question_has_knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.QuestionHasKnowledgeMapper.BaseResultMap")
    QuestionHasKnowledge selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionHasKnowledge record);

    @Update({
        "update question_has_knowledge",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "knowledge_id = #{knowledgeId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasKnowledge record);
}