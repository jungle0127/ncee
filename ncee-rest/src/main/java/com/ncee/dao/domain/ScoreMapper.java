package com.ncee.dao.domain;

import com.ncee.dao.model.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(Score record);

    @Select({
        "select",
        "id, score, active",
        "from score",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.ScoreMapper.BaseResultMap")
    Score selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Score record);

    @Update({
        "update score",
        "set score = #{score,jdbcType=INTEGER},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Score record);
}