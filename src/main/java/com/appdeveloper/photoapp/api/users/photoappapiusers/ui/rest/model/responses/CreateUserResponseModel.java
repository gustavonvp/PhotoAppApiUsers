package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.responses;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserResponseModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
