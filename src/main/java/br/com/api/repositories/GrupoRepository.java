package br.com.api.repositories;

import br.com.api.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

/*@NamedQueries({
        @NamedQuery(name = "GrupoRepository.findByAdministradorId", query = "SELECT g.nome FROM GrupoIntegr")
})*/
public interface GrupoRepository extends JpaRepository<Grupo, Long> {


    /*List<Grupo> findByAdministradorId(@Param("administradorId") Long administradorId);*/
}
