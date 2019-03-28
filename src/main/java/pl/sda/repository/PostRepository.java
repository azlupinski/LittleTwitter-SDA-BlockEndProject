package pl.sda.repository;

import com.google.common.collect.Lists;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import pl.sda.config.DbUtil;
import pl.sda.model.Post;
import pl.sda.model.enimeration.Role;
import pl.sda.service.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class PostRepository {


    private static PostRepository instance = null;
    private static UserService userService = UserService.getInstance();
    private MongoCollection<Document> postCollection;

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private PostRepository() {

        postCollection = DbUtil.getConnection().getCollection("posts");
//        posts = new ArrayList<>();
//        posts.add(new Post( LocalDateTime.now(),
//                "bad news", 2L, "everybody dies", userService.getUserByIdService(3L)));
//        posts.add(new Post( LocalDateTime.now(),
//                "neutral news", 3L,
//                "everybody dies, but its normal",userService.getUserByIdService(1L) ));
//        posts.add(new Post( LocalDateTime.now(),
//                "good news", 1L,
//                "everybody dies but there is an afterlife", userService.getUserByIdService(2L) ));

    }

    public List<Post> getPosts() {
        return Lists
                .newArrayList(postCollection.find())
                .stream().map(Post::getDocumentAsPost)
                .collect(Collectors.toList());
    }

    public Optional<Post> getPostById(String id) {
        Document document = postCollection.find(eq("postId", id)).first();

        return Optional.ofNullable(Post.getDocumentAsPost(document));
    }


    public void save(Post post) {
            postCollection.insertOne(post.getPostAsDocument());;
    }

    public void delte(Post post) {
        postCollection.deleteOne(post.getPostAsDocument());
    }

//    public boolean userExist(String login) {
//        return users.stream().anyMatch(user -> user.getLogin().equals(login));
//    }



}
