package br.com.unisinos.clinica.abc.dao;

import br.com.unisinos.clinica.abc.fixture.model.PacienteFixtureBuilder;
import br.com.unisinos.clinica.abc.repository.PacienteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PacienteDAOTest {

    private PacienteRepository repository;
    private PacienteDAO dao;

    @Before
    public void setup() {
        this.repository = mock(PacienteRepository.class);
        this.dao = new PacienteDAO(repository);
    }

    @Test
    public void hasPrimeiraConsulta() throws Exception {
        PacienteFixtureBuilder pacienteFixtureBuilder = new PacienteFixtureBuilder().withName("Valdo").withPrimeiraConsulta(true);
        String paciente = "Valdo";
        when(repository.findOneByName(eq(paciente))).thenReturn(pacienteFixtureBuilder.build());

        boolean hasPrimeiraConsulta = dao.hasPrimeiraConsulta(paciente);
        Assert.assertTrue(hasPrimeiraConsulta);
    }

    @Test
    public void pacienteNotFound() throws Exception {
        String paciente = "Valdo";
        when(repository.findOneByName(eq(paciente))).thenReturn(null);

        boolean hasPrimeiraConsulta = dao.hasPrimeiraConsulta(paciente);
        Assert.assertFalse(hasPrimeiraConsulta);
    }

}
