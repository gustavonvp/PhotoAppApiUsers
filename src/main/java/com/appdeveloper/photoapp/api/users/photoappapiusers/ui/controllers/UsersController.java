package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.controllers;

import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.requests.CreateUserRequestModel;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared.UserDto;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.services.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final Environment env;

    @Autowired
    UsersService usersService;

    public UsersController(Environment env) {
        this.env = env;
    }

    @GetMapping("/status/check")
    public String status() {
        return

                "Working on port:" + env.getProperty("local.server.port");
    }


    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        usersService.createUser(userDto);
        return "Create user method is called";
    }
}
