package authentication;

import domain.ID;
import domain.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Value {
    private final UserID userID;
    private final String password;
    private final Map<String, List<Permissions>> cachePermissionsMap = new HashMap<>();

    public User(UserID userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public User(String  userID, String password) {
        this.userID = new UserID(userID);
        this.password = password;
    }

    public void changePermissionsForCache(String cacheName, Permissions permissions) {
        if (cachePermissionsMap.containsKey(cacheName)) {
            if (!cachePermissionsMap.get(cacheName).contains(permissions)) {
                cachePermissionsMap.get(cacheName).add(permissions);
            }
            else {
                System.out.println("Already Granted");
            }
        }
        else {
            System.out.println("Access Denied for this cache");
        }
    }

    @Override
    public ID getID() {
        return this.userID;
    }
    public String getPassword() {
        return this.password;
    }


}
