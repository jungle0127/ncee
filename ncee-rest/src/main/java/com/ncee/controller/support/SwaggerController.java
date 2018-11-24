package com.ncee.controller.support;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SwaggerController {
    @ApiIgnore("Ignore swagger home page.")
    @RequestMapping("/swagger")
    public void redirect2Swagger(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/ncee/swagger-ui.html");
    }
}
