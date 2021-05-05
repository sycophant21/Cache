package cache;

import authentication.Authentication;
import authentication.User;

public class CacheAuthenticator {
    private Authentication authentication;
    private CacheFactory cacheFactory;

    public CacheAuthenticator() {
        authentication = new Authentication(CacheFactory.getInstance().getCache("user"));
    }

    public CacheLayer authenticate(String userId, String password) {
        User user = authentication.authenticateUser(userId, password);
        return new CacheLayer(CacheFactory.getInstance(), user);

    }
}
