package authentication;

import cache.Cache;
import cache.CacheFactory;

public class Authentication {
    private final Cache cache;
    public Authentication(Cache cache) {
        this.cache = cache;
    }

    public User authenticateUser(String userID, String password) {
        if (password.equalsIgnoreCase(((User)cache.get(new UserID(userID))).getPassword())) {
            System.out.println("Authenticated");
            return ((User)cache.get(new UserID(userID)));
        }
        throw new RuntimeException("UserID-Password doesn't match");
    }

}
