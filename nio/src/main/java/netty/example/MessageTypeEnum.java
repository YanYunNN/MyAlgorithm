package netty.example;

public enum MessageTypeEnum {
    USER_REGISTER("1"),
    USER_QUESTION("2"),
    USER_HELLO("3"),
    RG_REGISTER("4"),
    RG_USER_MESSAGE("5");

    private String type;

    MessageTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
