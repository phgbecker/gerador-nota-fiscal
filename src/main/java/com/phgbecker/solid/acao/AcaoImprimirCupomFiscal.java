package com.phgbecker.solid.acao;

import com.phgbecker.solid.nota_fiscal.NotaFiscal;

public class AcaoImprimirCupomFiscal implements AcaoNotaFiscal {

    @Override
    public void executar(NotaFiscal notaFiscal) {
        System.out.println("Imprimindo comprovante fiscal da NF-e...");
    }
}
