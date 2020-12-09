package com.example.demo;

import java.util.Locale;
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

    public static String getArea(Map<String, String> body) {
        String type = body.get("type");
        StringBuilder outerString = new StringBuilder("Area of a ");
        Locale locale = Locale.forLanguageTag("en-US");
        if(type.equals("circle")) {
            int radius = Integer.parseInt(body.get("radius"));
            double area = Math.PI * Math.pow(radius, 2);

            String endOfString = String.format(locale, "circle with a radius of %d is %.5f", radius, area);
            outerString.append(endOfString);
        }//end of if-statement
        else if(type.equals("rectangle")) {
            int width = Integer.parseInt(body.get("width"));
            int height = Integer.parseInt(body.get("height"));
            int area = width * height;

            String endOfString = String.format(locale, "%dx%d rectangle is %d", width, height, area);
            outerString.append(endOfString);
        }//end of else-fi statement
        return outerString.toString();
    }
} //Not re-inventing the wheel; using other smart people's formulas
