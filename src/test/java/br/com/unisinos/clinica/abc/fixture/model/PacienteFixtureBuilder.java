package br.com.unisinos.clinica.abc.fixture.model;

import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;

public class PacienteFixtureBuilder {

    Paciente paciente;

    public PacienteFixtureBuilder() {
        this.paciente = new Paciente();
    }

    public PacienteFixtureBuilder withName(String name) {
        paciente.setNome(name);
        return this;
    }

    public PacienteFixtureBuilder withPrimeiraConsulta(boolean hadrimeiraConsulta) {
        this.paciente.hadPrimeiraConsulta(hadrimeiraConsulta);
        return this;
    }

    public Paciente build() {
        return paciente;
    }
}
