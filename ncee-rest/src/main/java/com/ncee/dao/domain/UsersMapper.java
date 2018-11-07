package com.ncee.dao.domain;

import com.ncee.dao.model.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
    @Select({
            "select",
            "id, username, password, phone_number, roleid, active",
            "from users",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @ResultMap("com.ncee.dao.domain.UsersMapper.BaseResultMap")
    Users selectByLoginName(String userName);
    @Select({
            "select",
            "id, username, password, roleid, active",
            "from users",
            "order by id desc"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="roleid", property="roleid", jdbcType=JdbcType.BIGINT),
            @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Users> selectAll();
    @Select({
            "select",
            "id, username, password, phone_number, roleid, active",
            "from users",
            "where phone_number = #{phoneNumber,jdbcType=CHAR}"
    })
    @ResultMap("com.ncee.dao.domain.UsersMapper.BaseResultMap")
    Users selectByPhoneNumber(String phoneNumber);

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