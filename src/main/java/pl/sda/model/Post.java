package pl.sda.model;



import org.bson.Document;
import org.bson.types.ObjectId;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Post {

    private LocalDateTime date;
    private String name;
    private String postId;
    private String postContent;
    private User user;

    public Post() {
    }


    public Post(LocalDateTime date, String name, String postId, String postContent, User user) {
        this.date = date;
        this.name = name;
        this.postId = postId;
        this.postContent = postContent;
        this.user = user;
    }

    public Document getPostAsDocument(){
        Document document = new Document("name", name).append("postContent", postContent).append("date", date).append("user", user.getUserAsDocument());
        if (Objects.nonNull(postId)){
            document.append("_id", new ObjectId(postId));
        }
        return document;
    }

    public static Post getDocumentAsPost(Document document){
        if (Objects.nonNull(document)) {
            String name = document.getString("name");
            String postContent = document.getString("postContent");
            Date date = document.getDate("date");
            ObjectId postId = document.getObjectId("_id");
            User user = User.getDocumentAsUser((Document) document.get("user"));
            LocalDateTime postDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


            Post post = new Post(postDate,name,postId.toString(),postContent,user);

            if (Objects.nonNull(postId)) {
                post.setPostId(postId.toString());
            }
            return post;
        } else {
            return null;
        }
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (date != null ? !date.equals(post.date) : post.date != null) return false;
        if (name != null ? !name.equals(post.name) : post.name != null) return false;
        if (postId != null ? !postId.equals(post.postId) : post.postId != null) return false;
        if (postContent != null ? !postContent.equals(post.postContent) : post.postContent != null) return false;
        return user != null ? user.equals(post.user) : post.user == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (postContent != null ? postContent.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", user=" + user +
                '}';
    }
}
