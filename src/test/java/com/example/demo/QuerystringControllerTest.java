package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuerystringController.class)
public class QuerystringControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testingIndexEndpoint() throws Exception {
        this.mvc.perform(get("/vehicles?year=1987%doors=2"))
                .andExpect(status().isOk());
    }//end of test
}
