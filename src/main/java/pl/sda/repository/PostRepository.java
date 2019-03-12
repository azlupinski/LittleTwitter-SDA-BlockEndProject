package pl.sda.repository;

import pl.sda.model.Post;
import pl.sda.model.enimeration.Role;
import pl.sda.service.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostRepository {

    private List<Post> posts;
    private static PostRepository instance = null;
    private static UserService userService = UserService.getInstance();

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private PostRepository() {
        posts = new ArrayList<>();
        posts.add(new Post( LocalDateTime.now(),
                "bad news", 2L, "everybody dies", userService.getUserByIdService(3L)));
        posts.add(new Post( LocalDateTime.now(),
                "neutral news", 3L,
                "everybody dies, but its normal",userService.getUserByIdService(1L) ));
        posts.add(new Post( LocalDateTime.now(),
                "good news", 1L,
                "everybody dies but there is an afterlife", userService.getUserByIdService(2L) ));

    }

    public List<Post> getPosts() {
        return posts;
    }

    public Optional<Post> getPostById(Long id) {
        return posts.stream()
                .filter(post -> post.getPostId().equals(id))
                .findFirst();
    }


    public void save(Post post) {posts.add(post);
    }

//    public boolean userExist(String login) {
//        return users.stream().anyMatch(user -> user.getLogin().equals(login));
//    }



}
