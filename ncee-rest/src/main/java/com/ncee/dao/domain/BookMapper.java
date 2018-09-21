package com.ncee.dao.domain;

import com.ncee.dao.model.Book;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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

    @Select({
        "select",
        "id, course_id, book, active",
        "from book",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="book", property="book", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    Book selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, course_id, book, active",
        "from book",
        "order by id desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="book", property="book", jdbcType=JdbcType.VARCHAR),
        @Result(column="active", property="active", jdbcType=JdbcType.INTEGER)
    })
    List<Book> selectAll();

    @Update({
        "update book",
        "set course_id = #{courseId,jdbcType=BIGINT},",
          "book = #{book,jdbcType=VARCHAR},",
          "active = #{active,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Book record);
}