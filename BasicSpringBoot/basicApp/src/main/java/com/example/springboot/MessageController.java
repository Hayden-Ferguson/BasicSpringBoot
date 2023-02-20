package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Reads text from message.txt into the web browser
@RestController
public class MessageController {

	@GetMapping("/")
	public String index() {
		Path messagePath = Path.of("message.txt");
		try
        {
            String message = Files.readString(messagePath);
    		
    		return message;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return "Something went wrong.";
	}

}