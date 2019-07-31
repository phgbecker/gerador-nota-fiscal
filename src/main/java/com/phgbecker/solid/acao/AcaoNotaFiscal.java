package com.phgbecker.solid.acao;

import com.phgbecker.solid.nota_fiscal.NotaFiscal;

@FunctionalInterface
public interface AcaoNotaFiscal {

    void executar(NotaFiscal notaFiscal);
}
