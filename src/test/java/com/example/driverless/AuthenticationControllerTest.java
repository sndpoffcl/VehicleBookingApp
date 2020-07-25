package com.example.driverless;

import com.upgrad.hirewheels.HireWheelsApplication;
import com.upgrad.hirewheels.dto.LoginDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HireWheelsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testSetUserLogin() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("upgrad@gmail.com");
        loginDTO.setPassword("admin@123");
        ResponseEntity response = restTemplate.postForEntity(getRootUrl() + "/authenticate/users/access-token", loginDTO, LoginDTO.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
    }

}
