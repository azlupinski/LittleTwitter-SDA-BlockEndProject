package pl.sda.service;

import pl.sda.model.User;
import pl.sda.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        this.userRepository = UserRepository.getInstance();
    }





    public Optional<User> loginUser(String login, String password) {
        return userRepository.getUserByLoginData(login, password);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserByIdService(Long id){
        if (userRepository.getUserById(id).isPresent())
        return userRepository.getUserById(id).get();
        else return User.JohnDoe;
    }
}
