package br.com.api.entities;

import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grupo {

    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
    private List<Administrador> administradores;
    private List<Integrante> integrantes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //    @Temporal(TemporalType.TIMESTAMP) should only be set on a java.util.Date or java.util.Calendar property: br.com.api.entities.Grupo.dataCriacao
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @PrePersist
    public void prePersist() {
        dataCriacao = new LocalDateTime();
    }

}
