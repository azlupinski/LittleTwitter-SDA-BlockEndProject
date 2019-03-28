package pl.sda.service;

import pl.sda.model.User;
import pl.sda.model.enimeration.Role;
import pl.sda.repository.UserRepository;
import pl.sda.util.BCrypt;
import pl.sda.util.ValidationError;

import java.util.Optional;

public class RegistrationService {

    private UserRepository userRepository;
    private static RegistrationService instance = null;

    public static RegistrationService getInstance() {
        if (instance == null) {
            instance = new RegistrationService();
        }
        return instance;
    }

    private RegistrationService() {
        this.userRepository = UserRepository.getInstance();
    }

    public Optional<ValidationError> validateUserData(String login, String password, String repeatPassword) {
        Optional<ValidationError> error = Optional.empty();
        if (userRepository.userExist(login)) {
            error = Optional.of(new ValidationError("login", "Ten login jest już zajęty!"));
        } else if (!password.equals(repeatPassword)) {
            error = Optional.of(new ValidationError("password", "Wpisane hasła nie są takie same!"));
        }
        return error;
    }

    public void registerUser(String login, String password) {
//        Long userId = IdGenerator.next();
        String newPass = encryptPassword(password);
        User user = new User(login, newPass, Role.USER);
        userRepository.save(user);
    }

    String encryptPassword(String password) {

        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
//        MessageDigest digest = null;
//        try {
//            digest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        assert digest != null;
//        digest.update(password.getBytes());
//        String md5Password = new BigInteger(1, digest.digest()).toString(16);
//        return md5Password;
        return generatedSecuredPasswordHash;
    }
}