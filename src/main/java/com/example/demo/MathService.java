package com.example.demo;

import java.util.Map;

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
    } //end of public-static for math

    public static Integer sum(Integer[] array) {
        Integer sum = 0;

        for(var i = 0; i < array.length; i++) {
            sum += array[i];
        } //end of for-loop
        return sum;
    } //end of public-static for sum

    public static String getVolumeString(Map<String, String> sideLengths) {
        int length = Integer.parseInt(sideLengths.get("length"));
        int width = Integer.parseInt(sideLengths.get("width"));
        int height = Integer.parseInt(sideLengths.get("height"));
        int volume = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);
    }
} //Not re-inventing the wheel; using other smart people's formulas
