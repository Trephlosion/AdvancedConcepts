package edu.famu.cftaskmanager.controller;

import edu.famu.cftaskmanager.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/api/user



@RequestMapping("/api/user")
@RestController
public class UsersController {


    private UserService service;


    public UsersController(UserService service) {
        this.service = service;
    }
}
