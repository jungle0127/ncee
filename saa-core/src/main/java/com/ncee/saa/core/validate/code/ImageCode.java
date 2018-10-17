package com.ncee.saa.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode{
    private BufferedImage image;
    public ImageCode(String code, LocalDateTime expiredTime, BufferedImage image){
        super(code,expiredTime);
        this.image = image;
    }
    public ImageCode(String code, Integer expiredInMinutes, BufferedImage image){
        super(code,expiredInMinutes);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
