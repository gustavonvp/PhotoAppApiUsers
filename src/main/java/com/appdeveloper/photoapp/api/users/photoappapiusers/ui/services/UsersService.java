package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.services;

import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
