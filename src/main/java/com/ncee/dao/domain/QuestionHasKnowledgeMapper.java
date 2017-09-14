package com.ncee.dao.domain;

import com.ncee.dao.model.QuestionHasKnowledge;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, question_id, knowledge_id, active",
        "from question_has_knowledge",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge_id", property="knowledgeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    QuestionHasKnowledge selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, question_id, knowledge_id, active",
        "from question_has_knowledge",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        @Result(column="knowledge_id", property="knowledgeId", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<QuestionHasKnowledge> selectAll();

    @Update({
        "update question_has_knowledge",
        "set question_id = #{questionId,jdbcType=BIGINT},",
          "knowledge_id = #{knowledgeId,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QuestionHasKnowledge record);
}