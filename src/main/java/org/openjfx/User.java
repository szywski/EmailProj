package org.openjfx;

import org.apache.commons.lang3.RandomStringUtils;

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

    void setPassword(String pass) {
        this.password = pass;
    }
    public void changeUserPassword(String password){
        this.setPassword(password);
    }

    @Override
    public String toString() {
        return eMail +" "+getPassword();
    }
    public String generateRandomPassword(){
        String password = RandomStringUtils.randomAlphabetic(8);
        this.setPassword(password);
        return password;
    }

    public StringBuilder generateEmailAddress(){
        StringBuilder address = new StringBuilder();
        address.append(name + ".");
        address.append(lastName + "@");
        address.append(department);
        address.append("company.com");
        eMail = address.toString();
        return address;
    }
}
