package entity.parser;

import enums.SkinType;

public class SkinParser {
    public static SkinType parseStrToSkinType(String str) {
        String type = str.toUpperCase();
        if (type.equals("NATURAL")) {
            return SkinType.NATURAL;
        } else if(type.equals("ARTIFICIAL")) {
            return SkinType.ARTIFICIAL;
        }
        return SkinType.ARTIFICIAL;
    }
}
