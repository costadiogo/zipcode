package com.search.zipcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ZipcodeControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthentication("inter", "inter");
        }
    }

    @Test
    public void getZipCodeWithStatus404() {
        testRestTemplate = testRestTemplate.withBasicAuth("1", "1");
        ResponseEntity<String> response = testRestTemplate.getForEntity("/v1/api/", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void getZipCodeWithStatus200() {
        testRestTemplate = testRestTemplate.withBasicAuth("1", "1");
        ResponseEntity<String> response = testRestTemplate.getForEntity("/v1/api/30190924", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
