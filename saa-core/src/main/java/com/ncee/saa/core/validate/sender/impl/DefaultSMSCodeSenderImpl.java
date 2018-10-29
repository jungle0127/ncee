package com.ncee.saa.core.validate.sender.impl;

import com.ncee.saa.core.validate.sender.SMSCodeSender;
import org.springframework.stereotype.Component;

public class DefaultSMSCodeSenderImpl implements SMSCodeSender {
    @Override
    public void send(String phoneNumber,String code){
        System.out.println(String.format("Send code %s to phone %s",code,phoneNumber));
    }
}
