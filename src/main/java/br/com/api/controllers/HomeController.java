package br.com.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
@CrossOrigin("*") // Aceitar requisições de qualquer domínio/lugar
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> home() {
        logger.info("HOME DA API");
        return new ResponseEntity("Hey o/", HttpStatus.OK);
    }

}
