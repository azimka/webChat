package chat.requests;

public class Message {

    public static final String USER_LOGIN = "Пользователь %s успешно авторизовался";

    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
