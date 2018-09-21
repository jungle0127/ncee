package com.ncee.dao.domain;

import com.ncee.dao.model.Score;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ScoreMapper {
    @Delete({
        "delete from score",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into score (id, score, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{score,jdbcType=INTEGER}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Score record);

    @Select({
        "select",
        "id, score, active",
        "from score",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Score selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, score, active",
        "from score",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Score> selectAll();

    @Update({
        "update score",
        "set score = #{score,jdbcType=INTEGER},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Score record);
}