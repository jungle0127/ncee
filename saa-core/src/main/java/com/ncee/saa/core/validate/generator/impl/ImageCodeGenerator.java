package com.ncee.saa.core.validate.generator.impl;

import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.code.ImageCode;
import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.generator.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Component("imageCodeGenerator")
public class ImageCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SAAProperties saaProperties;
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", this.saaProperties.getValidateCode().getImageCode().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",this.saaProperties.getValidateCode().getImageCode().getHeight());

        String code = RandomStringUtils.randomNumeric(this.saaProperties.getValidateCode().getImageCode().getLength());
        return new ImageCode(code,this.saaProperties.getValidateCode().getImageCode().getExpiredInSeconds(),null);
    }
    public BufferedImage createImage(){
        return null;
    }
    /**
     * Generate random ribbon for background of the image
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
