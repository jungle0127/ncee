package com.ncee.dao.domain;

import com.ncee.dao.model.ExamType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExamTypeMapper {
    @Delete({
        "delete from exam_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into exam_type (id, type, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(ExamType record);

    int insertSelective(ExamType record);

    @Select({
        "select",
        "id, type, active",
        "from exam_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.ExamTypeMapper.BaseResultMap")
    ExamType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExamType record);

    @Update({
        "update exam_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ExamType record);
}