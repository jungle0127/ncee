package com.ncee.service.impl;

import com.ncee.dao.domain.ProvinceMapper;
import com.ncee.dao.model.Province;
import com.ncee.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<Province> getAllProvinces() {
        return this.provinceMapper.selectAll();
    }
}
