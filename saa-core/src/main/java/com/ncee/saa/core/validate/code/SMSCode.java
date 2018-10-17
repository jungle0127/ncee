package com.ncee.saa.core.validate.code;

import java.time.LocalDateTime;

public class SMSCode extends ValidateCode {
    public SMSCode(String code, LocalDateTime expireTime) {
        super(code, expireTime);
    }

    public SMSCode(String code, Integer expireInMinutes) {
        super(code, expireInMinutes);
    }
}
