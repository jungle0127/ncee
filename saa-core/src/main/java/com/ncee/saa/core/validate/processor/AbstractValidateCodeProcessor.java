package com.ncee.saa.core.validate.processor;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.generator.ValidateCodeGenerator;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractValidateCodeProcessor<T extends ValidateCode> implements ValidateCodeProcessor {
    @Autowired
    private ValidateCodeRepository validateCodeRepository;
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;
    @Override
    public void process(ServletWebRequest request) throws IOException {
        T validateCode = create(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    private T create(ServletWebRequest request) {
        return null;
    }

    private void save(ServletWebRequest request, T validateCode) {
    }

    public abstract void send(ServletWebRequest request, T validateCode);
}
