package com.ncee.dao.domain;

import com.ncee.dao.model.KnowledgeModule;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, book_id, modulename, note, active",
        "from knowledge_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="modulename", property="modulename", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    KnowledgeModule selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, book_id, modulename, note, active",
        "from knowledge_module",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="modulename", property="modulename", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<KnowledgeModule> selectAll();

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