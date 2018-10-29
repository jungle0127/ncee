package com.ncee.saa.core.validate.code;

public enum ValidateCodeType {
    SMS {
        @Override
        public String getTypeOnValidate() {
            return "SMS";
        }
    },
    IMAGE {
        @Override
        public String getTypeOnValidate() {
            return "IMAGE";
        }
    };

    public abstract String getTypeOnValidate();
}
