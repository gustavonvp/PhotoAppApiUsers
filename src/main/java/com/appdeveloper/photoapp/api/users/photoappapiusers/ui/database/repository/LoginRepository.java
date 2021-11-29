package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.database.repository;

import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.database.persistent.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity, Long> {
    LoginEntity readByEmailAndPassword(String email, String password);
}
