package com.ncee.saa.core.validate.code;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateCodeTypeTest {
    @Test
    public void testGetType(){
        ValidateCodeType validateCodeType = ValidateCodeType.valueOf("IMAGE");
        Assert.assertNotNull(validateCodeType);
    }
}