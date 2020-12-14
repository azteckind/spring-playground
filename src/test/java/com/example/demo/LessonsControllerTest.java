package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private LessonRepository repository;

    @Test
    @Transactional
    public void testingGetByID() throws Exception {
        MockHttpServletRequestBuilder request = get("/lessons/4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.title", is("JPA")));
    }

    @Test
    @Transactional
     public void testingUpdateLesson() throws Exception {
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String title = "Spring Security";
        String json = String.format("{\"title\":\"%s\",\"deliveredOn\":\"%s\"}", title, today);

        MockHttpServletRequestBuilder request = patch("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.title", is("Spring Security")));
    }

    @Test
    @Transactional
    public void testingFindByTitle() throws Exception {
        Lesson lesson1 = new Lesson();
        lesson1.setTitle("BasketWeaving");
        Date date = new Date();
        lesson1.setDeliveredOn(date);
        repository.save(lesson1);

        this.mvc.perform(get("/lessons/find/BasketWeaving"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo(lesson1.getTitle())));
    }

    @Test
    @Transactional
    public void testingInBetweenDates() throws Exception {
       Lesson lesson1 = new Lesson();
       lesson1.setTitle("BeskarForging");
       Date date1 = new Date();
       lesson1.setDeliveredOn(date1);
       repository.save(lesson1);

       Lesson lesson2 = new Lesson();
       lesson2.setTitle("PhoenixTraining");
       Date date2 = new Date();
       lesson2.setDeliveredOn(date2);
       repository.save(lesson2);

       this.mvc.perform(get("/lessons/between?date1=2014-01-01&date2=2017-12-31"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].title", equalTo(lesson1.getTitle())));

    }


}
