package com.example.demo;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpringMath.class)
public class SpringMathTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testingPI() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk());
    }//end of PI test

    @Test
    public void testingPostSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }//end of POST Sum testing

    @Test
    public void testingNoOperations() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }//end of calculations with no operations

    @Test
    public void testingAddition() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=add"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }//end of calculations of addition

    @Test
    public void testingSubtraction() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=subtract"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }//end of calculations of subtraction

    @Test
    public void testingMultiplication() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=6&operation=multiply"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }//end of calculations of multiplication

    @Test
    public void testingDivision() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5&operation=divide"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }//end of calculations of division

    @Test
    public void testingVolumeOfRectanglePost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }//end of POST-ing the volume of a rectangle

    @Test
    public void testingVolumeOfRectanglePatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/math/volume/6/7/8");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }//end of PATCH-ing the volume of a rectangle

}
