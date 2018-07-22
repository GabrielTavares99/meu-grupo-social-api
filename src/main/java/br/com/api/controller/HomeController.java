package br.com.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> home() {
        System.out.println("Hey o/");
        return new ResponseEntity("Hey o/", HttpStatus.OK);
    }

}
