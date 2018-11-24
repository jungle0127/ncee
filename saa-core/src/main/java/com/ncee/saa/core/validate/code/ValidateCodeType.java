package com.ncee.saa.core.validate.code;

import com.ncee.saa.core.properties.SAAConstants;

public enum ValidateCodeType {
    SMS {
        @Override
        public String getTypeOnValidate() {
            return SAAConstants.DEFAULT_SMSCODE_PARAMETER_NAME;
        }
    },
    IMAGE {
        @Override
        public String getTypeOnValidate() {
            return SAAConstants.DEFAULT_IMAGECODE_PARAMETER_NAME;
        }
    };

    public abstract String getTypeOnValidate();
}
