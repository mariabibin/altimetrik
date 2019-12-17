package com.almdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.almdemo.Controller.CountryRestController;


@RunWith(PowerMockRunner.class)
@PrepareForTest(CountryRestController.class)
public class CountryRestControllerTest {
	
	  @Autowired
	  private MockMvc mockMvc;
	  
	 
    @Test
    void whenValidInput_thenReturns200() throws Exception {
    
       mockMvc.perform(MockMvcRequestBuilders.get("/wb/getCountry")
            .contentType("application/json")
            .param("ctcode", "USA"))
       .andReturn().equals("200");
           
    }
    
 

	@Test
    void whenNullValue_thenReturns400() throws Exception {
      
      
	     mockMvc.perform(MockMvcRequestBuilders.get("/wb/getCountry")
	             .contentType("application/json")
	             .param("ctcode", "USA"))
	     .andReturn().equals("400");
    }
}