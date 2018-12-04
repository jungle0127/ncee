package com.ncee.service;

import com.ncee.util.TestUtil;
import org.springframework.stereotype.Service;

@Service
public class MockService {
    public String testPowserMock(){
        TestUtil.check();
        return "powermock";
    }
}
