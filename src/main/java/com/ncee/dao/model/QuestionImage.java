package com.ncee.dao.model;

public class QuestionImage {
    private Long id;

    private String imageUrl;

    private String imageDescription;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription == null ? null : imageDescription.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}