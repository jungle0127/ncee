package com.ncee.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncee.dao.domain.ProvinceMapper;
import com.ncee.dao.model.Province;
import com.ncee.service.IProvinceService;

@Service("provinceService")
public class ProvinceService implements IProvinceService{
	private static final Logger logger = LoggerFactory.getLogger(ProvinceService.class);
	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> getAllProvinces() {
		List<Province> provinceList = this.provinceMapper.selectAll();
		if(null != provinceList) {
			logger.info("Got all provinces.");
			return provinceList;
		}
		logger.warn("Got no province.");
		return null;
	}

}
