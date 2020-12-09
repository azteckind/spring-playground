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

    @GetMapping("/flight")
    public String getFlight() {
        return "Flying High as a Kite";
    }

    @JsonGetter("Departs")
    public String getDepartureDateTime() {
        return departureDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @JsonGetter("Tickets")
    public HashSet<Ticket> getTickets() {
        return this.tickets;
    }

    public void setDepartureDateTime(int year, int month, int date, int hour, int minute) {
        this.departureDateTime = LocalDateTime.of(year, month, date, hour, minute);
    }

    private static class Ticket {
        private final int price;
        private final Person passenger;

        public Ticket(int price, Person passenger) {
            this.price = price;
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public Person getPassenger() {
            return passenger;
        }

    }//end of Ticket class

    private static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

    }//end of Person class
}
