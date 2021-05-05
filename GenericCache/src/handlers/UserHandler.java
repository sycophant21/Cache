package handlers;

import authentication.Permissions;
import authentication.User;
import authentication.UserID;
import cache.Cache;

import java.util.List;

public class UserHandler {


    private final Cache cache;

    public UserHandler(Cache cache) {

        this.cache = cache;
    }

    private void addUser(User user) {
        cache.addToCache(user);
    }

    public void createUser(UserID userID, String password, String nameOfCache, List<Permissions> permissionsList) {
        cache.addToCache(new User(userID, password));
    }
}
