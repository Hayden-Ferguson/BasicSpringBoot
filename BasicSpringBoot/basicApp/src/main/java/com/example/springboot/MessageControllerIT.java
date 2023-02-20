package com.example.springboot;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageControllerIT {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getMessage() throws Exception {
		Path messagePath = Path.of("message.txt");
		try
        {
            String message = Files.readString(messagePath);
    		
            ResponseEntity<String> response = template.getForEntity("/", String.class);
            assertThat(response.getBody()).isEqualTo(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}