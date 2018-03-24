package com.ncee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncee.dao.model.Province;
import com.ncee.service.IProvinceService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	@Autowired
	@Qualifier("provinceService")
	private IProvinceService provinceService;
	
	@GetMapping("/provinces")
	public List<Province> getAllProvinces(){
		return this.provinceService.getAllProvinces();
	}
	
	
}
