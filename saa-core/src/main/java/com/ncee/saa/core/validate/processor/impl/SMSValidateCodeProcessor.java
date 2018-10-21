package com.ncee.saa.core.validate.processor.impl;

import com.ncee.saa.core.validate.code.SMSCode;
import com.ncee.saa.core.validate.processor.AbstractValidateCodeProcessor;
import com.ncee.saa.core.validate.sender.SMSCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
@Component("SMSCodeProcessor")
public class SMSValidateCodeProcessor extends AbstractValidateCodeProcessor<SMSCode> {
    @Autowired
    private SMSCodeSender smsCodeSender;
    @Override
    public void send(ServletWebRequest request, SMSCode validateCode) throws ServletRequestBindingException {
        String phoneNumberParameterName = "";
        String phoneNumber = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),phoneNumberParameterName);
        smsCodeSender.send(phoneNumber,validateCode.getCode());
    }
}
