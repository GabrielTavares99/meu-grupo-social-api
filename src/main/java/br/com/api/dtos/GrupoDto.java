package br.com.api.dtos;

import br.com.api.entities.Administrador;
import br.com.api.entities.Integrante;
import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GrupoDto {

    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
    private List<Administrador> administradores;
    private List<Integrante> integrantes;


    public GrupoDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Nome não pode ser vázio.")
    @Length(min = 3, max = 255, message = "Nome deve ser maior igual a 3 e menor igual a 255")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }


}
