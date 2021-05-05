package authentication;

import domain.ID;

import java.util.Objects;

public class UserID implements ID {
    private final String userID;
    public UserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserID)) return false;
        UserID userID1 = (UserID) o;
        return Objects.equals(getUserID(), userID1.getUserID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID());
    }
}
