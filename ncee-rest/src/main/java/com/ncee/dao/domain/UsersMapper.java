package com.ncee.dao.domain;

import com.ncee.dao.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersMapper {
    @Delete({
        "delete from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into users (id, username, ",
        "password, phone_number, ",
        "roleid, active)",
        "values (#{id,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=CHAR}, ",
        "#{roleid,jdbcType=BIGINT}, #{active,jdbcType=INTEGER})"
    })
    int insert(Users record);

    int insertSelective(Users record);

    @Select({
        "select",
        "id, username, password, phone_number, roleid, active",
        "from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.UsersMapper.BaseResultMap")
    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    @Update({
        "update users",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone_number = #{phoneNumber,jdbcType=CHAR},",
          "roleid = #{roleid,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Users record);
}