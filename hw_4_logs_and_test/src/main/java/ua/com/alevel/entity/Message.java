package ua.com.alevel.entity;

public class Message extends BaseEntity {

    private String text;
    private String userId;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", userId='" + userId + '\'' +
                ", messageId='" + super.getId() + '\'' +
                '}';
    }
}
