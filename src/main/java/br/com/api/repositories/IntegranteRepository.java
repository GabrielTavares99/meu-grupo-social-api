package br.com.api.repositories;

import br.com.api.entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

    //    CHAMADA NAO BLOQUANTE NO BD
    @Transactional(readOnly = true)
    Integrante findByEmail(String email);
}
