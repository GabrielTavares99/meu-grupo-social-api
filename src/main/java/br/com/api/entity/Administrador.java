package br.com.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Administrador")
public class Administrador extends Pessoa {

    private Long id;
    private List<Grupo> grupos;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
