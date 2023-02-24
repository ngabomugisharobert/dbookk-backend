package com.example.dbookk;

//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import controller.VisitorController;
import com.example.dbookk.service.VisitorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


@SpringBootApplication
@RestController
public class DbookkApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DbookkApplication.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<String> example(){
		return ResponseEntity.ok("Hello World");
	}
}