package com.phgbecker.solid.acao;

import com.phgbecker.solid.nota_fiscal.NotaFiscal;

import java.util.Optional;

public class AcaoEnviarEmail implements AcaoNotaFiscal {

    @Override
    public void executar(NotaFiscal notaFiscal) {
        Optional<String> email = notaFiscal.getDestinatario().getEmail();

        if (email.isPresent())
            System.out.println("Enviando NF-e para o email do destinatário (" + email.get() + ")...");
    }

}
