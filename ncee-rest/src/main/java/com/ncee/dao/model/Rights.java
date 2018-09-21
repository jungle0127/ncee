package com.ncee.dao.model;

public class Rights {
    private Long id;

    private Long rightHolderId;

    private Long rightHolerType;

    private String rightUrl;

    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRightHolderId() {
        return rightHolderId;
    }

    public void setRightHolderId(Long rightHolderId) {
        this.rightHolderId = rightHolderId;
    }

    public Long getRightHolerType() {
        return rightHolerType;
    }

    public void setRightHolerType(Long rightHolerType) {
        this.rightHolerType = rightHolerType;
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl == null ? null : rightUrl.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}