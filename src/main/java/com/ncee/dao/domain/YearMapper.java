package com.ncee.dao.domain;

import com.ncee.dao.model.Year;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface YearMapper {
    @Delete({
        "delete from year",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into year (id, year, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{year,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Year record);

    int insertSelective(Year record);

    @Select({
        "select",
        "id, year, active",
        "from year",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.YearMapper.BaseResultMap")
    Year selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Year record);

    @Update({
        "update year",
        "set year = #{year,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Year record);
}