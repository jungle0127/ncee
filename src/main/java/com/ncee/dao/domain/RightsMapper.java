package com.ncee.dao.domain;

import com.ncee.dao.model.Rights;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RightsMapper {
    @Delete({
        "delete from rights",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into rights (id, right_holder_id, ",
        "right_holer_type, right_url, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{rightHolderId,jdbcType=BIGINT}, ",
        "#{rightHolerType,jdbcType=BIGINT}, #{rightUrl,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Rights record);

    @Select({
        "select",
        "id, right_holder_id, right_holer_type, right_url, active",
        "from rights",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="right_holder_id", property="rightHolderId", jdbcType=JdbcType.BIGINT),
        @Result(column="right_holer_type", property="rightHolerType", jdbcType=JdbcType.BIGINT),
        @Result(column="right_url", property="rightUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Rights selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, right_holder_id, right_holer_type, right_url, active",
        "from rights",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="right_holder_id", property="rightHolderId", jdbcType=JdbcType.BIGINT),
        @Result(column="right_holer_type", property="rightHolerType", jdbcType=JdbcType.BIGINT),
        @Result(column="right_url", property="rightUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Rights> selectAll();

    @Update({
        "update rights",
        "set right_holder_id = #{rightHolderId,jdbcType=BIGINT},",
          "right_holer_type = #{rightHolerType,jdbcType=BIGINT},",
          "right_url = #{rightUrl,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Rights record);
}