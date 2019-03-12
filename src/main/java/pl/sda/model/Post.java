package pl.sda.model;



import java.time.LocalDateTime;

public class Post {

    private LocalDateTime date;
    private String name;
    private Long postId;
    private String postContent;
    private User user;

    public Post() {
    }


    public Post(LocalDateTime date, String name, Long postId, String postContent, User user) {
        this.date = date;
        this.name = name;
        this.postId = postId;
        this.postContent = postContent;
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
