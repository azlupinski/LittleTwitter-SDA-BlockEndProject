package pl.sda.util;

public class Message {

    private String value;
    private MessageType type;

    public static Message success(String message) {
        return new Message(message, MessageType.SUCCESS);
    }

    public static Message error(String message) {
        return new Message(message, MessageType.ERROR);
    }

    public static Message info(String message) {
        return new Message(message, MessageType.INFO);
    }

    public static Message warning(String message) {
        return new Message(message, MessageType.WARNING);
    }

    private Message(String message, MessageType type) {
        this.value = message;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type.name();
    }

    private enum MessageType {
        INFO, SUCCESS, ERROR, WARNING;
    }
}

