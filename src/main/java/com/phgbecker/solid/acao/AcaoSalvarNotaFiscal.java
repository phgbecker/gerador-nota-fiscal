package com.phgbecker.solid.acao;

import com.phgbecker.solid.nota_fiscal.NotaFiscal;

public class AcaoSalvarNotaFiscal implements AcaoNotaFiscal {

    @Override
    public void executar(NotaFiscal notaFiscal) {
        System.out.println("Salvando NF-e nº " + notaFiscal.getDetalhe().getNumero() + " no banco de dados...");
    }
}
