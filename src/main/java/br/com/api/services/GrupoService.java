package br.com.api.services;

import br.com.api.dtos.GrupoDto;
import br.com.api.entities.Grupo;
import br.com.api.repositories.GrupoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public void cadastrarGrupo(GrupoDto grupoDto, BindingResult result) {

        validarDados(grupoDto, result);
        Grupo grupo = new Grupo();
        BeanUtils.copyProperties(grupoDto, grupo);

        grupoRepository.save(grupo);
    }

    private void validarDados(GrupoDto grupoDto, BindingResult result) {
        Grupo empresa = grupoRepository.findGrupoByNome(grupoDto.getNome());
        if (empresa != null)
            result.addError(new ObjectError("nome do grupo", "Nome de grupo já cadastrado"));

    }

}
