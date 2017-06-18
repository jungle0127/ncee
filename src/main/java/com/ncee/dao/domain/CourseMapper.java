package com.ncee.dao.domain;

import com.ncee.dao.model.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseMapper {
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into course (id, exam_type_id, ",
        "course, active)",
        "values (#{id,jdbcType=BIGINT}, #{examTypeId,jdbcType=BIGINT}, ",
        "#{course,jdbcType=VARCHAR}, #{active,jdbcType=INTEGER})"
    })
    int insert(Course record);

    int insertSelective(Course record);

    @Select({
        "select",
        "id, exam_type_id, course, active",
        "from course",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.CourseMapper.BaseResultMap")
    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update course",
        "set exam_type_id = #{examTypeId,jdbcType=BIGINT},",
          "course = #{course,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Course record);
}