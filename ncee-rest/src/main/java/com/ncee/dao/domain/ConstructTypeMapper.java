package com.ncee.dao.domain;

import com.ncee.dao.model.ConstructType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ConstructTypeMapper {
    @Delete({
        "delete from construct_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into construct_type (id, type, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(ConstructType record);

    int insertSelective(ConstructType record);

    @Select({
        "select",
        "id, type, active",
        "from construct_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.ConstructTypeMapper.BaseResultMap")
    ConstructType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConstructType record);

    @Update({
        "update construct_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ConstructType record);
}