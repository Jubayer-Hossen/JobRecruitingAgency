package jubayer.hossen.jobrecruitingagency.AppAdmin;

import jubayer.hossen.jobrecruitingagency.User.User;

public class AppAdmin extends User {
    private String username;

    public AppAdmin(String userID, String password, String name, String email, String username) {
        super(userID, password, name, email);
        this.username = username;
    }

    public AppAdmin(String username, String password, String name, String email) {
        super(username, password, name, email);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
