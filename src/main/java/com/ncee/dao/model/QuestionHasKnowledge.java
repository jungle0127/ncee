package com.ncee.dao.model;

public class QuestionHasKnowledge {
    private Long id;

    private Long questionId;

    private Long knowledgeId;

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

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}