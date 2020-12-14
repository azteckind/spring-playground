package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.is;



@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void canGetByID() throws Exception {
        MockHttpServletRequestBuilder request = get("/lessons/4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.title", is("JPA")));
    }

}
