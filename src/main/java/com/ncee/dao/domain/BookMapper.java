package com.ncee.dao.domain;

import com.ncee.dao.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookMapper {
    @Delete({
        "delete from book",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into book (id, course_id, ",
        "book, active)",
        "values (#{id,jdbcType=BIGINT}, #{courseId,jdbcType=BIGINT}, ",
        "#{book,jdbcType=VARCHAR}, #{active,jdbcType=INTEGER})"
    })
    int insert(Book record);

    int insertSelective(Book record);

    @Select({
        "select",
        "id, course_id, book, active",
        "from book",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.ncee.dao.domain.BookMapper.BaseResultMap")
    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    @Update({
        "update book",
        "set course_id = #{courseId,jdbcType=BIGINT},",
          "book = #{book,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Book record);
}