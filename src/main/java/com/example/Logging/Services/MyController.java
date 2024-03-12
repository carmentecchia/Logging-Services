package com.example.Logging.Services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MyController {
@Autowired
private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/")
    public String welcome() {
        logger.info("Welcome message");
        return "Welcome to my application!";
    }

    @GetMapping("/exp")
    public String calculatePower() {
        int envVar1 = 2;
        int envVar2 = 8;
        logger.info("Calculating power");
        double result = Math.pow(envVar1, envVar2);
        logger.debug("Power calculation result: {}", result);
        return "Power calculation result: " + result;
    }

    @GetMapping("/get-errors")
    public void getError() {
        Error error = new Error("Error");
        logger.error("Custom error: ", error);
    }
}