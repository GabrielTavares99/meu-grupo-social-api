package br.com.api.services;

import br.com.api.dtos.IntegranteDto;
import br.com.api.entities.Integrante;
import br.com.api.repositories.IntegranteRepository;
import br.com.api.utils.PasswordUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class IntegranteService {

    @Autowired
    IntegranteRepository integranteRepository;

    public Object cadastrar(IntegranteDto integranteDto, BindingResult result) {
        validarDados(integranteDto, result);
        if (result.hasErrors())
            return result;
        Integrante integrante = new Integrante();
        BeanUtils.copyProperties(integranteDto, integrante);
        integrante.setSenha(PasswordUtils.gerarHashSenhaBCrypt(integrante.getSenha()));
        integranteRepository.save(integrante);
        return integranteDto;
    }

    private void validarDados(IntegranteDto integranteDto, BindingResult result) {
        Integrante integrante = integranteRepository.findByEmail(integranteDto.getEmail());
        if (integrante != null)
            result.addError(new ObjectError("Email", "Email já cadastrado!"));

    }
}
