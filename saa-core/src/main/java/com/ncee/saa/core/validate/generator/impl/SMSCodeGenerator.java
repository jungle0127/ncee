package com.ncee.saa.core.validate.generator.impl;

import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.code.SMSCode;
import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.generator.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
@Component("smsCodeGenerator")
public class SMSCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SAAProperties saaProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        Integer codeLength = this.saaProperties.getValidateCode().getSmsCode().getLength();
        Integer expiredInSeconds = this.saaProperties.getValidateCode().getSmsCode().getExpiredInSeconds();
        String code = RandomStringUtils.randomNumeric(codeLength);
        return new SMSCode(code,expiredInSeconds);
    }
}
