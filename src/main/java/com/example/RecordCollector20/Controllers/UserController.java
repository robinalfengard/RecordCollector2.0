package com.example.RecordCollector20.Controllers;


import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.UserRepository;
import com.example.RecordCollector20.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/getId/{email}")
    public ResponseEntity<String> getId(@PathVariable String email){
        return userService.getId(email);
    }

    @GetMapping("/finduser/{email}")
    public ResponseEntity<Optional<User>> findUser(@PathVariable String email){
        return userService.findUserByEmail(email);
    }





}





