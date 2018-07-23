package br.com.api.controllers;

import br.com.api.dtos.GrupoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/grupo/")
@CrossOrigin("*")
public class GrupoController {

    private static final Logger logger = LoggerFactory.getLogger(GrupoController.class);



    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<GrupoDto> cadastraGrupo(@Valid @RequestBody GrupoDto grupoDto, BindingResult result) {


        return ResponseEntity.ok(grupoDto);
    }

}
