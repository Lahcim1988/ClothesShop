package entity.parser;

import java.awt.*;

public class ColorParser {

    public static enums.Color parseStrToColor(String str) {
        String color = str.toUpperCase();
        if (color.equals("RED")) {
            return enums.Color.RED;
        } else if (color.equals("BLUE")) {
            return enums.Color.BLUE;
        } else if (color.equals("BLACK")) {
            return enums.Color.BLACK;
        } else if (color.equals("YELLOW")) {
            return enums.Color.YELLOW;
        } else if (color.equals("GREEN")) {
            return enums.Color.GREEN;
        } else if (color.equals("WHITE")) {
            return enums.Color.WHITE;
        }
        return enums.Color.WHITE;
    }
}
