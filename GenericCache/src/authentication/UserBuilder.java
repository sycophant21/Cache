package authentication;

public class UserBuilder {

    private String userId;
    private String password;

    public UserBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(userId, password);
    }
}
