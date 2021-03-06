package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SpringMath {

    @GetMapping("/math/pi")
    public String pi() {
        return "3.141592653589793";
    } //Re-doing the Spring Math into a cleaner format

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam Integer x, @RequestParam Integer y, @RequestParam(defaultValue = "add") String operation) {
        return MathService.calculate(operation, x, y).toString();
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer [] n) {
        return MathService.sum(n).toString();
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
        public String volume(@PathVariable Map<String, String> pathVariables) {
            return MathService.getVolumeString(pathVariables);
    }//Using RequestMapping, which covers both POST and PATCH, and 'cause I'm lazy an' don' wanna write this out twice

    @PostMapping("/math/area")
    public String area(@RequestParam Map<String, String> body) {
        String type = body.get("type");
        boolean hasCircleParams = type.equals("circle") && body.containsKey("radius");
        boolean hasRectangleParams = type.equals("rectangle") && body.containsKey("width") && body.containsKey("height");
        if(hasCircleParams || hasRectangleParams) {
            return MathService.getArea(body);
        }//end of if-statement
        else {
            return "Invalid";
        }//end of else-statement
    }
}
