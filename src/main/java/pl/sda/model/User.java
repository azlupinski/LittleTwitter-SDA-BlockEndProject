package pl.sda.model;

import org.bson.Document;
import org.bson.types.ObjectId;
import pl.sda.model.enimeration.Role;

import java.util.Objects;

public class User {
    private String userId;
    private String login;
    private String password;
    private Role role;

    public static final User JohnDoe = new User("123456L", "JOHN DOE", "yadontknow", Role.USER);

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Document getUserAsDocument(){
        Document document = new Document("login", login).append("password", password).append("role", role.name());
        if (Objects.nonNull(userId)){
            document.append("_id", new ObjectId(userId));
        }
        return document;
    }

    public static User getDocumentAsUser(Document document){
        if (Objects.nonNull(document)) {
            String login = document.getString("login");
            String pasword = document.getString("password");
            Role role = Role.valueOf(document.getString("role"));
            ObjectId id = document.getObjectId("_id");


            User user = new User(login, pasword, role);

            if (Objects.nonNull(id)) {
                user.setUserId(id.toString());
            }
            return user;
        } else {
            return null;
        }
    }



    public User() {

    }




    public User(String userId, String login, String password, Role role) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public boolean isAdmin() {
        return Role.ADMIN.equals(role);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }


}
