package com.ncee.saa.core.validate.sender;

public interface SMSCodeSender {
    void send(String phoneNumber,String code);
}
