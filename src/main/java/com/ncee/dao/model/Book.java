package com.ncee.dao.model;

public class Book {
    private Long id;

    private Long courseId;

    private String book;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book == null ? null : book.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}