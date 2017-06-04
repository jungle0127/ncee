package com.ncee.dao.domain;

import com.ncee.dao.model.Users;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UsersMapper {
    @Delete({
        "delete from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into users (id, username, ",
        "password, roleid, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{roleid,jdbcType=BIGINT}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Users record);

    @Select({
        "select",
        "id, username, password, roleid, active",
        "from users",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleid", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Users selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, username, password, roleid, active",
        "from users",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleid", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Users> selectAll();

    @Update({
        "update users",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "roleid = #{roleid,jdbcType=BIGINT},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Users record);
}