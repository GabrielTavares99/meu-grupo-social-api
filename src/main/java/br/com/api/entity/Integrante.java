package br.com.api.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Integrante extends Pessoa {

    private Long id;
    private List<Grupo> grupos;

    public Integrante() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

}
