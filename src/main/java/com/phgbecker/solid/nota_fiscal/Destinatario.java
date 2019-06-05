package com.phgbecker.solid.nota_fiscal;

import java.util.Optional;

public class Destinatario {
    private final String nome;
    private final String email;

    public Destinatario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
