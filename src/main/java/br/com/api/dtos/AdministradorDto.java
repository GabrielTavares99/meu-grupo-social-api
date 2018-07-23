package br.com.api.dtos;

import br.com.api.entities.Grupo;
import br.com.api.enums.TipoPerfil;
import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AdministradorDto {

    private String nome;
    private String email;
    private String telefone;
    private Long id;
    private TipoPerfil tipoPerfil;
    private List<Grupo> grupos;
    private LocalDateTime dataCriacao;

    @NotNull(message = "Nome não pode ser vázio.")
    @Length(min = 3, max = 255, message = "Nome deve ser maior igual a 3 e menor igual a 255")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
