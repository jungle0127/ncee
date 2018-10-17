package com.ncee.saa.core.validate.code;

public enum ValidateCodeType {
    SMS_CODE {
        @Override
        public String getTypeOnValidate() {
            return "SMS";
        }
    },
    IMAGE_CODE {
        @Override
        public String getTypeOnValidate() {
            return "IMAGE";
        }
    };

    public abstract String getTypeOnValidate();
}
