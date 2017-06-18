package com.ncee.dao.domain;

import com.ncee.dao.model.CheckType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CheckTypeMapper {
    @Delete({
        "delete from check_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into check_type (id, type, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(CheckType record);

    int insertSelective(CheckType record);

    @Select({
        "select",
        "id, type, active",
        "from check_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.CheckTypeMapper.BaseResultMap")
    CheckType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckType record);

    @Update({
        "update check_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CheckType record);
}