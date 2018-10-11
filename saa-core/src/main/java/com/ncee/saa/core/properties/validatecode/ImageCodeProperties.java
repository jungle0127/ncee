package com.ncee.saa.core.properties.validatecode;

public class ImageCodeProperties extends SMSCodeProperties {
    public ImageCodeProperties(){
        setLength(4);
    }
    private Integer width = 67;
    private Integer height = 23;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
