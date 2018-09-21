package com.ncee.service.impl;

import com.ncee.dao.model.Province;
import com.ncee.service.ProvinceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceServiceImplTest {
    @Autowired
    private ProvinceService provinceService;
    @Test
    public void getAllProvinces() throws Exception {
        List<Province> provinceList = this.provinceService.getAllProvinces();
        Assert.assertTrue(provinceList.size() > 0);
    }

}