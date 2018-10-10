package com.ncee.saa.core.properties;

import com.ncee.saa.core.properties.oauth2.OAuth2Properties;
import com.ncee.saa.core.properties.validatecode.ValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ncee.saa")
public class SAAProperties {
    private ValidateCodeProperties validateCode;
    private OAuth2Properties oauth2;

    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }
}
