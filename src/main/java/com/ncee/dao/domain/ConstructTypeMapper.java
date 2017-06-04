package com.ncee.dao.domain;

import com.ncee.dao.model.ConstructType;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, type, active",
        "from construct_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    ConstructType selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, type, active",
        "from construct_type",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<ConstructType> selectAll();

    @Update({
        "update construct_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ConstructType record);
}