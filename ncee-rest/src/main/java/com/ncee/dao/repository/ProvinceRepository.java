package com.ncee.dao.repository;

import com.ncee.dao.domain.ProvinceMapper;
import com.ncee.dao.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceRepository {
    @Autowired
    private ProvinceMapper provinceMapper;
    public List<Province> getAllProvinces() {
        return this.provinceMapper.selectAll();
    }
}
