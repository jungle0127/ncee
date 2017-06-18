package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeModule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KnowledgeModuleMapper {
    @Delete({
        "delete from knowledge_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into knowledge_module (id, book_id, ",
        "modulename, note, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{bookId,jdbcType=BIGINT}, ",
        "#{modulename,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(KnowledgeModule record);

    int insertSelective(KnowledgeModule record);

    @Select({
        "select",
        "id, book_id, modulename, note, active",
        "from knowledge_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.KnowledgeModuleMapper.BaseResultMap")
    KnowledgeModule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KnowledgeModule record);

    @Update({
        "update knowledge_module",
        "set book_id = #{bookId,jdbcType=BIGINT},",
          "modulename = #{modulename,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(KnowledgeModule record);
}