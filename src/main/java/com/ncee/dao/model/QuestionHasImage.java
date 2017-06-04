package com.ncee.dao.model;

public class QuestionHasImage {
    private Long id;

    private Long questionId;

    private Long questionImageId;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionImageId() {
        return questionImageId;
    }

    public void setQuestionImageId(Long questionImageId) {
        this.questionImageId = questionImageId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}