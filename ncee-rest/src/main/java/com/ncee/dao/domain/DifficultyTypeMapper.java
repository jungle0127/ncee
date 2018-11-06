package com.ncee.dao.domain;

import com.ncee.dao.model.DifficultyType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DifficultyTypeMapper {
    @Delete({
        "delete from difficulty_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into difficulty_type (id, type, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(DifficultyType record);

    int insertSelective(DifficultyType record);

    @Select({
        "select",
        "id, type, active",
        "from difficulty_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.DifficultyTypeMapper.BaseResultMap")
    DifficultyType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DifficultyType record);

    @Update({
        "update difficulty_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DifficultyType record);
}