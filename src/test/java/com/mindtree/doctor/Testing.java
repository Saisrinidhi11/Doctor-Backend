package com.mindtree.doctor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class Testing extends DoctorBackendApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

   @Before
   public void setup() {
	   mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
   
   @Test
   public void testDoctor()  throws Exception{
	   mockMvc.perform(get("/doctors")).andExpect(status().isOk())
	   .andExpect(content().contentType("application/json;charset=UTF-8"))
	   .andExpect(jsonPath("$.id").value("20"))
	   .andExpect(jsonPath("$.age").value("35"))
	   .andExpect(jsonPath("$.gender").value("male"))
	   .andExpect(jsonPath("$.name").value("Dr Akash"))
	   .andExpect(jsonPath("$.specialistField").value("Neurology"));
   }   
	   
   }








