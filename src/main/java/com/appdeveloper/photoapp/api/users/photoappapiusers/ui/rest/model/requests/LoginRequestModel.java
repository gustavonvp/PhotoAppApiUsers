package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequestModel {

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal 8 characters or maximum at 16 characters.")
    private String password;

    @NotNull(message = "Email must not be null")
    @Email
    private String email;

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
