package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComent(Comment comment) {
        comments.add(comment);
    }

    public void removeComent(Comment comment) {
        comments.remove(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(title + "\n");
        sb.append(likes);
        sb.append(" Likes - ");
        sb.append(moment.format(sdf) + "\n");
        sb.append(content + "\n");
        sb.append("Comments:\n");
        for (Comment c : comments) {
            sb.append(c + "\n");
        }

        return sb.toString();
    }
}
