package com.ncee.saa.core.validate.processor.impl;

import com.ncee.saa.core.validate.code.ImageCode;
import com.ncee.saa.core.validate.processor.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

@Component("imageCodeProcessor")
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    @Override
    public void send(ServletWebRequest request, ImageCode validateCode) throws IOException {
        ImageIO.write(validateCode.getImage(),"JPG",request.getResponse().getOutputStream());
    }
}
