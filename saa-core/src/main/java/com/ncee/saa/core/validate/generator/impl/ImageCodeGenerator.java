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
        Integer width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", this.saaProperties.getValidateCode().getImageCode().getWidth());
        Integer height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",this.saaProperties.getValidateCode().getImageCode().getHeight());
        Integer expiredInSeconds = this.saaProperties.getValidateCode().getImageCode().getExpiredInSeconds();
        String code = RandomStringUtils.randomNumeric(this.saaProperties.getValidateCode().getImageCode().getLength());

        BufferedImage bufferedImage = createImage(width,height,code);

        return new ImageCode(code, expiredInSeconds,bufferedImage);
    }
    private BufferedImage createImage(Integer width,Integer height, String code){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        for(int index = 0; index < code.length();index++){
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(code.charAt(index)), 13 * index + 6, 16);
        }
        g.dispose();
        return image;
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
