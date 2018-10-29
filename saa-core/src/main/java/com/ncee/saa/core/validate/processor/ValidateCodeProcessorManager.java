package com.ncee.saa.core.validate.processor;

import com.ncee.saa.core.validate.code.ValidateCodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidateCodeProcessorManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessorMap;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType validateCodeType){
        return findValidateCodeProcessor(validateCodeType.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String validatecodeType){
        String processorName = validatecodeType.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessorMap.get(processorName);
        if(validateCodeProcessor == null){
            logger.error(String.format("Can not find the processor with class name:%s",processorName));
        }
        return validateCodeProcessor;
    }
}
