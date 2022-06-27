package com.paribas.tictactoe.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebMvcTest(controllers = TicTacToeController.class)
public class tictactoecontrollertest {

	@Autowired
    private WebApplicationContext wac;
     
    @Autowired
    private MockMvc mockMvc;
    
     
    @Test
    public void checkS() throws Exception{
         mockMvc.perform(MockMvcRequestBuilders.post("/api/start").param("playerOne", "Tim").param("playerTwo", "Tim2"))
               .andExpect(MockMvcResultMatchers.status().isOk());
 
    }
    @Test
    public void checkPlay() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/play").param("x", "0").param("y", "0"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

}