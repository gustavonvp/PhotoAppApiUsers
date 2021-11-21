package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.services.implementations;

import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.database.persistent.UserEntity;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.database.repository.UserRepository;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared.UserDto;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.services.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    UserRepository userRepository;


    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity user = modelMapper.map(userDetails, UserEntity.class);
        user.setEcryptedPassword("test");


        userRepository.save(user);

        UserDto returnValue = modelMapper.map(user, UserDto.class);

        return returnValue;
    }
}
