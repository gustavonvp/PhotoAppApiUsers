package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.controllers;

import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.requests.CreateUserRequestModel;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.requests.LoginRequestModel;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.responses.CreateUserResponseModel;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.model.responses.LoginResponseModel;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared.LoginDto;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.rest.shared.UserDto;
import com.appdeveloper.photoapp.api.users.photoappapiusers.ui.services.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createUser = usersService.createUser(userDto);

        CreateUserResponseModel returnValue = modelMapper.map(createUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @PostMapping(value =  "/login",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LoginResponseModel> loginUser(@Valid @RequestBody LoginRequestModel login ) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        LoginDto loginDto = modelMapper.map(login, LoginDto.class);


        loginDto.setEmail(login.getEmail());
        loginDto.setPassword(login.getPassword());

        LoginDto loginAcess = usersService.loginUser(loginDto);

        LoginResponseModel returnLogin = modelMapper.map(loginAcess, LoginResponseModel.class);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnLogin);

    }





}
