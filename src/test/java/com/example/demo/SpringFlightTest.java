package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SpringFlight.class)
public class SpringFlightTest {
    @Autowired
    private MockMvc mvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testingDepartureFlight() throws Exception {
        this.mvc.perform(get("/flights/flight")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is("2017-04-21 14:34")));

    }//end of test for departure flight

    @Test
    public void testingTicketing() throws Exception {
        this.mvc.perform(get("/flights/flight")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Some name")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("Some other name")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)));
    }//end of ticketing test

}
