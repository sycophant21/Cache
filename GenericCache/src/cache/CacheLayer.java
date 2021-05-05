package cache;

import authentication.User;

public class CacheLayer {
    private final CacheFactory instance;
    private final User user;

    public CacheLayer(CacheFactory instance, User user) {

        this.instance = instance;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
