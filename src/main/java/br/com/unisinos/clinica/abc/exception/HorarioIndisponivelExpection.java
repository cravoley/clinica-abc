package br.com.unisinos.clinica.abc.exception;

public class HorarioIndisponivelExpection extends RuntimeException {
    public HorarioIndisponivelExpection() {
    }

    public HorarioIndisponivelExpection(String message) {
        super(message);
    }
}
