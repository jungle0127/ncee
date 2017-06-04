package com.ncee.dao.model;

public class KnowledgeModule {
    private Long id;

    private Long bookId;

    private String modulename;

    private String note;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}