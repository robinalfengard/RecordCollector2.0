package com.example.RecordCollector20.Services;

import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> getId(String email){
        User user = userRepository.findByEmail(email).get();
        if (user.getEmail().equals(email)){
            return ResponseEntity.ok(user.getId().toString());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Optional<User>> findUserByEmail(String email){

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }




}
