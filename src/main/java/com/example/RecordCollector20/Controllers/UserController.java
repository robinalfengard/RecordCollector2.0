package com.example.RecordCollector20.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

@GetMapping("/message")
    public ResponseEntity<String> test() {return ResponseEntity.ok("This is safe");}
}


