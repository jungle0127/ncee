package com.ncee.controller;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ncee.dao.model.Province;
import com.ncee.service.IProvinceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private IProvinceService provinceServie;
	@InjectMocks
	private CatalogController catalogController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(catalogController).build();
	}
	@Test
	public void testGetAllProvinces() {
		List<Province> provinceList = new LinkedList<>();
		Province pojo = new Province();
		pojo.setProvince("山东");
		provinceList.add(pojo);
		
		Mockito.when(this.provinceServie.getAllProvinces()).thenReturn(provinceList);
		
		try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/catalog/provinces").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
