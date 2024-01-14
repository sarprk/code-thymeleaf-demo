package com.javapractice.springboot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping
    public String GetDockerMessage() {
        return "Dockerizing spring boot application.";
    }
}
