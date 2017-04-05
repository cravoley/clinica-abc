package br.com.unisinos.clinica.abc.controller.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AgendarRequest {
    @NotNull Long idUsuario;
    @NotNull LocalDateTime horarioConsulta;
    String descricao;


    public Long getIdUsuario() {
        return idUsuario;
    }

    public LocalDateTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public String getDescricao() {
        return descricao;
    }
}
