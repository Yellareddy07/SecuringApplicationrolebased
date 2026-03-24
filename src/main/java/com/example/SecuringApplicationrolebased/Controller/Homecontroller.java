package com.example.SecuringApplicationrolebased.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

    @GetMapping("/normal")
    public ResponseEntity<String> normaluser(){
        return ResponseEntity.ok("I am normal user");
    }


    @GetMapping("/admin")
    public ResponseEntity<String> adminuser(){
        return ResponseEntity.ok("I am admin user");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicuser(){
        return ResponseEntity.ok("I am public user");
    }
}
