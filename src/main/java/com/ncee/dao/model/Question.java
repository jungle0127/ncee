package com.ncee.dao.model;

public class Question {
    private Long questionId;

    private String question;

    private Long questionTypeId;

    private Long constructTypeId;

    private String answer;

    private Integer active;

    private String analysis;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Long getConstructTypeId() {
        return constructTypeId;
    }

    public void setConstructTypeId(Long constructTypeId) {
        this.constructTypeId = constructTypeId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }
}