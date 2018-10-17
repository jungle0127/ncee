package com.ncee.saa.core.validate.code;

import java.time.LocalDateTime;

public class ValidateCode {
    private String code;
    private LocalDateTime expireTime;
    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }
    public ValidateCode(String code, Integer expireInMinutes){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusMinutes(Long.valueOf(expireInMinutes));
    }
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(this.expireTime);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
