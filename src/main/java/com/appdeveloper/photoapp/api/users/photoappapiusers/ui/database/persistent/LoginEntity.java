package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.database.persistent;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="login")
public class LoginEntity implements Serializable {

    private static final long serialVersionUID = -12231554354354321L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(nullable = false, length = 120, unique = true)
    private String email;


    @Size(min = 8, max = 16, message = "Password must be equal 8 characters or maximum at 16 characters.")
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
