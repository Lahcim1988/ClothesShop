package enums;

public enum  ColorEnum {

    BLACK("#000000"),
    WHITE("#FFFFFF"),
    RED("#FF0000"),
    GREEN("#008000"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00");

    private String hex;

    ColorEnum(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
