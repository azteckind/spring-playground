package com.example.demo;

public class MathService {
    public static Integer calculate(String operation, int x, int y) {
        if(operation.equals("subtract")) {
            return Math.subtractExact(x, y);
        } //end of if-statement
        else if(operation.equals("multiply")) {
            return Math.multiplyExact(x, y);
        } //end of else-if statement for multiply
        else if(operation.equals("divide")) {
            return Math.floorDiv(x, y);
        } //end of else-fi statement for division
        return Math.addExact(x,y);
    } //end of public-static
} //Not re-inventing the wheel; using other smart people's formulas
