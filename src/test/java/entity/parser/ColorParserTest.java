package entity.parser;

import enums.Color;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorParserTest {

    @Test
    public void testParseColorRed() {
        String strColor = "rEd";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(Color.RED, color);
    }

}
