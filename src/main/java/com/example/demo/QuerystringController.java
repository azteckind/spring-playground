package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequestMapping("/app")
public class QuerystringController {

    @GetMapping("/individual-example")
    public String getIndividualParams(@RequestParam String filter) {
          return String.format("Filter is : %s", filter);
    }

    @GetMapping("/people")
    public String getPeople(
            @RequestParam("sort-by") String sortBy,
            @RequestParam(value = "sort-dir") String sortDirection) {
        return String.format("sortBy is %s and sortDirection is %s", sortBy, sortDirection);
    }

    @GetMapping("/vehicle")
    public String myCoolMethod(@RequestParam(required = false) String type) {
        return type;
    }

    @GetMapping("/other")
    public String myCoolMethod2(@RequestParam(value = "type", defaultValue = "car") String type) {
        return type;
    }

    @GetMapping("/map-example")
    public String getMapParams(@RequestParam Map querystring) {
        return querystring.toString();
    }

} //Created Query string separate from the rest
