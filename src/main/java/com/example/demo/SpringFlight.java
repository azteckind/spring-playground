package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@RestController
@RequestMapping("/flights")
public class SpringFlight {
    private LocalDateTime departureDateTime;
    private final HashSet<Ticket> tickets = new HashSet<>();

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    public LocalDateTime getDepartureDateTime() {
//        return departureDateTime;
//    }

    @GetMapping("/flight")
    public String getFlight() {
        return "Flying High as a Kite";
    }

    @JsonGetter("departs")
    public String getDepartureDateTime() {
        return departureDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    private static class Ticket {

    }
}
