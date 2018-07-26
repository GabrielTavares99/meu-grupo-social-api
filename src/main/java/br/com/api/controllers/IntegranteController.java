package br.com.api.controllers;

import br.com.api.dtos.IntegranteDto;
import br.com.api.services.IntegranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("api/integrante")
public class IntegranteController {

    @Autowired
    IntegranteService integranteService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity cadastrar(@Valid @RequestBody IntegranteDto integranteDto,
                                    BindingResult result) {

        Object isCadastrado = integranteService.cadastrar(integranteDto, result);

        if (!(isCadastrado instanceof BindingResult))
            return ResponseEntity.ok(integranteDto);
        else
            return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
    }

}
