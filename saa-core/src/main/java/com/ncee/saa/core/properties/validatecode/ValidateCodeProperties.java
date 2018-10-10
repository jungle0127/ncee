package com.ncee.saa.core.properties.validatecode;

public class ValidateCodeProperties {
    private SMSCodeProperties sms;
    private ImageCodeProperties image;

    public SMSCodeProperties getSms() {
        return sms;
    }

    public void setSms(SMSCodeProperties sms) {
        this.sms = sms;
    }

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
