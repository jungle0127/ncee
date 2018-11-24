package com.ncee.controller.support;

import com.ncee.dto.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/test")
    public RestResponse<String> test(){
        RestResponse<String> response = new RestResponse<String>("TEST");
        response.setCode("0");
        response.setMessage("OK");
        return response;
    }
}
