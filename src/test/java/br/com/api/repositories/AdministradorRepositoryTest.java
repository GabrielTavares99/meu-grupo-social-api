package br.com.api.repositories;

import br.com.api.entity.Administrador;
import br.com.api.enums.TipoPerfil;
import br.com.config.MygroupApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MygroupApplication.class)
@ActiveProfiles("test")
public class AdministradorRepositoryTest {

    private static final String EMAIL = "adm@ig.com";
    @Autowired
    private AdministradorRepository administradorRepository;

    @Before
    public void setUp() {
        Administrador administrador = new Administrador();
        administrador.setEmail(EMAIL);
        administrador.setNome("José Filho");
        administrador.setTipoPerfil(TipoPerfil.ROLE_ADMINISTRADOR);
        administradorRepository.save(administrador);
    }

    @Test
    public void testCadastroAdministrador() {
        Administrador administrador = administradorRepository.findByEmail(EMAIL);
        Assert.assertEquals(EMAIL, administrador.getEmail());
    }

    @Test
    public void testAdministradorInexistente() {
        Administrador administrador = administradorRepository.findByEmail("email@email.com");
        Assert.assertNull(administrador);
    }

    @After
    public void tearDown() {
        administradorRepository.deleteAll();
    }

}
