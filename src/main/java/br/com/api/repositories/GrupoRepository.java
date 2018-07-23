package br.com.api.repositories;

import br.com.api.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

/*@NamedQueries({
        @NamedQuery(name = "GrupoRepository.findByAdministradorId", query = "SELECT g.nome FROM GrupoIntegr")
})*/
public interface GrupoRepository extends JpaRepository<Grupo, Long> {


    Grupo findGrupoByNome(String nome);

    /*List<Grupo> findByAdministradorId(@Param("administradorId") Long administradorId);*/
}
