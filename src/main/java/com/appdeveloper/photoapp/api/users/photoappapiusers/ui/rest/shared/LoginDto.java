package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared;

import java.io.Serializable;

public class LoginDto implements Serializable {

    private static final long serialVersionUID = -12345664663128958L;

    private String email;
    private String password;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
