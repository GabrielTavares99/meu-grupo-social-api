package br.com.api.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class IntegranteDto {

    @Length(min = 3, max = 255, message = "Nome fora do tamanho esperado [3-255 ]")
    @NotNull(message = "Não pode ser nulo")
    private String nome;

    @Email(message = "Email inválido")
    @NotNull(message = "Não pode ser nulo")
    private String email;

    @NotNull(message = "Não pode ser nulo")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
