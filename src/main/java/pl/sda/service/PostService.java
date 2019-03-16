package pl.sda.service;

import pl.sda.model.Post;
import pl.sda.model.User;
import pl.sda.repository.PostRepository;
import pl.sda.repository.UserRepository;
import pl.sda.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.List;

public class PostService {
    PostRepository postRepository;
    UserRepository userRepository;
    private static PostService instance = null;

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    private PostService() {
        this.postRepository = PostRepository.getInstance();
        this.userRepository = UserRepository.getInstance();
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public void registerPost(String name, String postContent, User user) {
        Long postId = IdGenerator.next();
        Post post = new Post();
        post.setDate(LocalDateTime.now());
        post.setName(name);
        post.setPostContent(postContent);
        post.setUser(user);
        postRepository.save(post);
    }

    public void deletePost(Long id) {
        if (postRepository.getPostById(id).isPresent()) {
            Post post = postRepository.getPostById(id).get();
           postRepository.delte(post);
        }
    }


}
