package com.ncee.saa.core.properties.validatecode;

public class ValidateCodeProperties {
    private SMSCodeProperties smsCode = new SMSCodeProperties();
    private ImageCodeProperties imageCode = new ImageCodeProperties();

    public SMSCodeProperties getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(SMSCodeProperties smsCode) {
        this.smsCode = smsCode;
    }

    public ImageCodeProperties getImageCode() {
        return imageCode;
    }

    public void setImageCode(ImageCodeProperties imageCode) {
        this.imageCode = imageCode;
    }
}
