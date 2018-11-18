package com.ncee.saa.core.properties;

public interface SAAConstants {
    String DEFAULT_LOGIN_PAGE = "default-sign-in.html";
    String DEFAULT_FORM_SIGN_IN_PROCESSING_URL = "/authentication/form";
    String DEFAULT_SMS_SIGN_IN_PROCESSING_URL = "/authentication/sms";
    String AUTHENTICATION_URL = "/authentication/authenticate";
    String OAUTH_TOKEN = "/oauth/token";
    String VALIDATE_CODE_IMAGE_URL = "/validate/code/image";
    String VALIDATE_CODE_SMS_URL = "/validate/code/sms";
    String IMAGE_CODE_SESSION_KEY = "SESSION_KEY_CODE_IMAGE";
    String SMS_CODE_SESSION_KEY = "SESSION_KEY_CODE_SMS";
    String DEFAULT_PHONENUMBER_PARAMETER_NAME = "phoneNumber";
    String DEFAULT_SMSCODE_PARAMETER_NAME = "smsCode";
    String DEFAULT_IMAGECODE_PARAMETER_NAME = "imageCode";
    String DEFAULT_OAUTH_CLIENT_ID = "ncee";
    String DEFAULT_OAUTH_CLIENT_SECRET= "secret";
}
