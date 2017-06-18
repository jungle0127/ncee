package com.ncee.dao.domain;

import com.ncee.dao.model.Rights;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    int insertSelective(Rights record);

    @Select({
        "select",
        "id, right_holder_id, right_holer_type, right_url, active",
        "from rights",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.RightsMapper.BaseResultMap")
    Rights selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rights record);

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