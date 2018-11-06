package com.ncee.dao.domain;

import com.ncee.dao.model.Province;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProvinceMapper {
    @Delete({
        "delete from province",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into province (id, province, ",
        "active)",
        "values (#{id,jdbcType=BIGINT}, #{province,jdbcType=VARCHAR}, ",
        "#{active,jdbcType=INTEGER})"
    })
    int insert(Province record);

    int insertSelective(Province record);

    @Select({
        "select",
        "id, province, active",
        "from province",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.ProvinceMapper.BaseResultMap")
    Province selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Province record);

    @Update({
        "update province",
        "set province = #{province,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Province record);
}