package com.api.aula.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World :) v.1.0";
    }

    @RequestMapping("/country")
    public Map<String, String> country() {
        java.util.HashMap<String, Object> map = new java.util.HashMap<>();
        map.put("name", "Robson Cruz");
        map.put("age", "38");
        map.put("from", "Brazil");
        return map;
    }
}
