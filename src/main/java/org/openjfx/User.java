package org.openjfx;

public class User {

    String name;
    String lastName;
    String department;
    String eMail;
    int id;
    private String password;



    public void newPassword(String newPassword){
        this.setPassword(newPassword);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return eMail +" "+getPassword();
    }
}
