package jubayer.hossen.jobrecruitingagency.User;

public abstract class User {
    private final String userID;
    private String name;
    private String email;
    private String password;

    public User(String userID, String password, String name, String email) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public User login(String email, String password){
        if(this.email.equals(email) && this.password.equals(password)){
            return this;
        }
        else {
            return null;
        }
    }

    public void logout(){
        //
    }

    public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword){
        if (oldPassword.equals(this.password) && newPassword.equals(confirmNewPassword)) {
            this.password = newPassword;
            return true;
        }
        else {
            return false;
        }

    }

    public boolean updateProfile(){
        //
        return true;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }
}
