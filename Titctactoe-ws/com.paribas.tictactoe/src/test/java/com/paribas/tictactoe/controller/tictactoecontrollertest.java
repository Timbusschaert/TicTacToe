package com.paribas.tictactoe.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TicTacToeController.class)
public class tictactoecontrollertest {

	 @Autowired
    private WebApplicationContext wac;
     
      
    private MockMvc mockMvc;
     
    @Before
    public void init() {
         this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
     
    @Test
    public void checkS() throws Exception{
         mockMvc.perform(MockMvcRequestBuilders.post("/api/start"))
               .andExpect(MockMvcResultMatchers.status().isOk());
 
    }
    @Test
    public void checkPlay() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/play"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

}