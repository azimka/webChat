package chat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="text")
    private String text;
    @Column(name="author")
    private String author;
    @Column(name="createDate")
    private Date createDate;

    public MessageModel() {
    }

    public MessageModel(String text, String author, Date createDate) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ",\"text\":\"" + text + '\"' +
                ",\"author\":\"" + author + '\"' +
                ",\"createDate\":\"" + createDate + "\"" +
                '}';
    }
}
