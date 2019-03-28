package pl.sda.repository;

import com.google.common.collect.Lists;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import pl.sda.config.DbUtil;
import pl.sda.model.User;
import pl.sda.model.enimeration.Role;
import pl.sda.util.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class UserRepository {

    private List<User> users;
    private static UserRepository instance = null;
    private MongoCollection<Document> usersCollection;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
//        users = new ArrayList<>();
        usersCollection = DbUtil.getConnection().getCollection("users");
//        users.add(new User("1L","user", "user123", Role.USER));
//        users.add(new User("2L","admin", "admin123", Role.ADMIN));
//        users.add(new User("3L","test", "test123", Role.USER));
    }

    public List<User> getUsers() {
        return Lists
                .newArrayList(usersCollection.find())
                .stream().map(User::getDocumentAsUser)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(String id) {
        Document document = usersCollection.find(eq("userId", id)).first();

        return Optional.ofNullable(User.getDocumentAsUser(document));

    }

    public Optional<User> getUserByLoginData(String login, String password) {

        Document document =  usersCollection
                .find(eq("login", login)).first();
        Optional<User> foundUser = Optional.ofNullable(User.getDocumentAsUser(document));
        if (foundUser.isPresent()){
            User user = foundUser.get();
            boolean passCheck = BCrypt.checkpw(password, user.getPassword());
            if (passCheck){
                return Optional.ofNullable(User.getDocumentAsUser(document));
            }
        }
//      Document document =  usersCollection
//              .find(and(eq("login", login),
//                      eq("password", password))).first();

     return Optional.ofNullable(null);

    }


    public void save(User user) {
        if (!userExist(user.getLogin()))
        usersCollection.insertOne(user.getUserAsDocument());
        //users.add(user);
    }

    public boolean userExist(String login) {
       boolean exists = Objects
               .nonNull(usersCollection
                       .find(eq("login", login))
                       .first());
//               isEmpty();

        return exists;
    }
}
