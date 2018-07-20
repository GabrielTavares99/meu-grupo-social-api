package br.com.api.entity;

import br.com.api.enums.TipoPerfil;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public class Pessoa {

    private String nome;
    private String email;
    private String telefone;
    private Long id;
    private TipoPerfil tipoPerfil;
    private List<Grupo> grupos;
    private LocalDateTime dataCriacao;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Enumerated(EnumType.STRING)
    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    //    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @PrePersist
    public void prePersist() {
        setDataCriacao(new LocalDateTime());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
