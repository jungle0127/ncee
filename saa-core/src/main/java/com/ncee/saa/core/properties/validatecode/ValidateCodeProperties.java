package com.ncee.saa.core.properties.validatecode;

public class ValidateCodeProperties {
    private SMSCodeProperties smsCode;
    private ImageCodeProperties imageCode;

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
