package com.ncee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.ncee.support.AutoconfigureConstants.WEB_UI_DIR_NAME;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.servlet.HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE;

@RestController
public class MapperController {
    @Value("classpath:"+WEB_UI_DIR_NAME+"/index.html")
    Resource indexHtml;

    @RequestMapping(value = "/"+WEB_UI_DIR_NAME+"/index.html", method = GET)
    public ResponseEntity<Resource> serveIndex() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES))
                .body(indexHtml);
    }

    @RequestMapping(value = {"/"+WEB_UI_DIR_NAME+"/","/"+WEB_UI_DIR_NAME+"/manage/**"}, method = GET)
    public ModelAndView forwardUiEndpoints() {
        return new ModelAndView("forward:/"+WEB_UI_DIR_NAME+"/index.html");
    }

    @RequestMapping(value = {"/","/index"}, method = GET)
    public void redirectRoot(HttpServletResponse response) throws IOException {
        response.setHeader(HttpHeaders.LOCATION, "./"+WEB_UI_DIR_NAME+"/");
        response.setStatus(HttpStatus.FOUND.value());
    }

    @RequestMapping(value = "/"+WEB_UI_DIR_NAME+"/api/**", method = {POST,GET,DELETE})
    public ModelAndView forwardApi(HttpServletRequest request) {
        String path = (String) request.getAttribute(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        return new ModelAndView("forward:" + path.replaceFirst("/"+WEB_UI_DIR_NAME, ""));
    }

    @RequestMapping(value = "/"+WEB_UI_DIR_NAME+"/authentication/*", method = POST)
    public ModelAndView forwardAuthentication(HttpServletRequest request) {
        String path = (String) request.getAttribute(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        return new ModelAndView("forward:" + path.replaceFirst("/"+WEB_UI_DIR_NAME, ""));
    }
}
