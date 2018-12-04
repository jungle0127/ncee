package com.ncee.service;

import com.ncee.util.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({TestUtil.class})
public class MockServiceTest {
    @InjectMocks
    private MockService mockService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks( this );

    }

    @Test
    public void testPowserMock() {
        PowerMockito.mockStatic(TestUtil.class);
        PowerMockito.when(TestUtil.check()).thenReturn("UT");
//        PowerMockito.doReturn("UT").when(TestUtil.check());
        String result =this.mockService.testPowserMock();
        System.out.printf(result);
    }
}