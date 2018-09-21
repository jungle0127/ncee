package com.ncee.dao.model;

public class QuestionSelection {
    private Long questionSelectionId;

    private Long questionId;

    private String selectionIndex;

    private String selection;

    private Integer active;

    public Long getQuestionSelectionId() {
        return questionSelectionId;
    }

    public void setQuestionSelectionId(Long questionSelectionId) {
        this.questionSelectionId = questionSelectionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getSelectionIndex() {
        return selectionIndex;
    }

    public void setSelectionIndex(String selectionIndex) {
        this.selectionIndex = selectionIndex == null ? null : selectionIndex.trim();
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection == null ? null : selection.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}