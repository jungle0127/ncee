package com.ncee.dao.domain;

import com.ncee.dao.model.Course;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, exam_type_id, course, active",
        "from course",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="exam_type_id", property="examTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="course", property="course", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, exam_type_id, course, active",
        "from course",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="exam_type_id", property="examTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="course", property="course", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectAll();

    @Update({
        "update course",
        "set exam_type_id = #{examTypeId,jdbcType=BIGINT},",
          "course = #{course,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Course record);
}