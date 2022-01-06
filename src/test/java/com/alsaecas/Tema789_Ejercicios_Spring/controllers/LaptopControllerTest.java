package com.alsaecas.Tema789_Ejercicios_Spring.controllers;

import com.alsaecas.Tema789_Ejercicios_Spring.Tema789EjerciciosSpringApplication;
import com.alsaecas.Tema789_Ejercicios_Spring.entities.Laptop;
import com.alsaecas.Tema789_Ejercicios_Spring.repositories.LaptopRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    @Order(1)
    void findAll() {

        ResponseEntity<Laptop[]> response  =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    @Order(3)
    void findOneById() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(2)
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "brand": "Laptop creado desde Spring Test",
                    "model": "V15",
                    "ram": 8,
                    "herzs": 2.6,
                    "price": 999.5,
                    "touch": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Laptop creado desde Spring Test", result.getBrand());
    }

    @Test
    @Order(4)
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "id": 1,
                    "brand": "Laptop actualizado desde Spring Test",
                    "model": "V15",
                    "ram": 8,
                    "herzs": 2.6,
                    "price": 999.5,
                    "touch": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Laptop actualizado desde Spring Test", result.getBrand());
    }

    @Test
    @Order(5)
    void delete() {
        HttpEntity<String> request = new HttpEntity<>(null);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/1", HttpMethod.DELETE,request, Laptop.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    @Order(6)
    void create2() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "brand": "Laptop 2 creado desde Spring Test",
                    "model": "V15",
                    "ram": 8,
                    "herzs": 2.6,
                    "price": 999.5,
                    "touch": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(2L, result.getId());
        assertEquals("Laptop 2 creado desde Spring Test", result.getBrand());
    }

    @Test
    @Order(7)
    void deleteAll() {
        HttpEntity<String> request = new HttpEntity<>(null);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.DELETE,request, Laptop.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    @Order(8)
    void findAll2() {

        ResponseEntity<Laptop[]> response  =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        assertEquals(laptops.size(),0);
    }
}