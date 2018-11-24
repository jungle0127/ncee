package com.ncee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/metadata")
public class PaperMetadataController {
    @GetMapping("/provinces")
    public List<String> getProvinceList(){
        List<String> provinceList = new LinkedList<>();
        provinceList.add("Shandong");
        return provinceList;
    }
}
