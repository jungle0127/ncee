package com.ncee.dao.domain;

import com.ncee.dao.model.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserRoleMapper {
    @Delete({
        "delete from user_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_role (id, role_name, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{roleName,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(UserRole record);

    int insertSelective(UserRole record);

    @Select({
        "select",
        "id, role_name, active",
        "from user_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.UserRoleMapper.BaseResultMap")
    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    @Update({
        "update user_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserRole record);
}