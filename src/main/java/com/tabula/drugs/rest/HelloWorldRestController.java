package com.tabula.drugs.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Vladyslav_Vinnyk on 12/14/2016.
 */
@RestController
public class HelloWorldRestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
