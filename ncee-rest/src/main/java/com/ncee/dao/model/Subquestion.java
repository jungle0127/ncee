package com.ncee.dao.model;

public class Subquestion {
    private Long id;

    private String subquestion;

    private Long questionId;

    private Long scoreId;

    private Integer sqindex;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubquestion() {
        return subquestion;
    }

    public void setSubquestion(String subquestion) {
        this.subquestion = subquestion == null ? null : subquestion.trim();
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getSqindex() {
        return sqindex;
    }

    public void setSqindex(Integer sqindex) {
        this.sqindex = sqindex;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}