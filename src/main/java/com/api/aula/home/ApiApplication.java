package com.api.aula.home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    @ResponseBody
    ResponseEntity<Object> home() {
        HashMap<String, Object> map = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        map.put("api-aula", "v.1.0.0-" + dateFormat.format(date));

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @RequestMapping("/me")
    @ResponseBody
    public ResponseEntity<Object> me() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Robson Cruz");
        map.put("age", "38");
        map.put("from", "Brazil");

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
