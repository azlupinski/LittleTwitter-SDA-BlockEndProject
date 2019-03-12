package pl.sda.model;

import pl.sda.model.enimeration.Role;

public class User {
    private Long userId;
    private String login;
    private String password;
    private Role role;

    public User() {

    }

    public static final User JohnDoe = new User(123456L, "JOHN DOE", "yadontknow", Role.USER);



    public User(Long userId, String login, String password, Role role) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
