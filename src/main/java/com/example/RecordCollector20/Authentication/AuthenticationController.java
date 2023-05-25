package com.example.RecordCollector20.Authentication;

import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/getId/{email}")
    public ResponseEntity<String> getId(@PathVariable String email){
        User user = userRepository.findByEmail(email).get();
        if (user.getEmail().equals(email)){
            return ResponseEntity.ok(user.getId().toString());
        }
        return ResponseEntity.noContent().build();
    }



}
