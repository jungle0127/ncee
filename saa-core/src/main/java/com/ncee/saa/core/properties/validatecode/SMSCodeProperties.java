package com.ncee.saa.core.properties.validatecode;

public class SMSCodeProperties {
    private int length;
    private int expiredInSeconds;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpiredInSeconds() {
        return expiredInSeconds;
    }

    public void setExpiredInSeconds(int expiredInSeconds) {
        this.expiredInSeconds = expiredInSeconds;
    }
}
