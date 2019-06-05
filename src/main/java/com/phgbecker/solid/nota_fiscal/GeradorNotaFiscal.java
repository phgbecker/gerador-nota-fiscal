package com.phgbecker.solid.nota_fiscal;

import com.phgbecker.solid.acao.AcaoNotaFiscal;
import com.phgbecker.solid.imposto.Imposto;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class GeradorNotaFiscal {
    private final Detalhe detalhe;
    private final Emitente emitente;
    private final Destinatario destinatario;
    private final List<Produto> produtos;
    private final List<Imposto> impostos;
    private final List<AcaoNotaFiscal> acoesAposEmissao;

    public GeradorNotaFiscal(Detalhe detalhe, Emitente emitente, Destinatario destinatario, List<Produto> produtos, List<Imposto> impostos, List<AcaoNotaFiscal> acoesAposEmissao) {
        this.detalhe = requireNonNull(detalhe, "Objeto Detalhe inválido");
        this.emitente = requireNonNull(emitente, "Objeto Emitente inválido");
        this.destinatario = requireNonNull(destinatario, "Objeto Destinatário inválido");
        this.produtos = requireNonNull(produtos, "Objeto Produtos inválido");
        this.impostos = requireNonNull(impostos, "Objeto Impostos inválido");
        this.acoesAposEmissao = acoesAposEmissao;
    }

    public NotaFiscal gerar() {
        NotaFiscal notaFiscal = new NotaFiscal(
                detalhe,
                emitente,
                destinatario,
                produtos,
                impostos
        );

        if (acoesAposEmissao != null)
            acoesAposEmissao.forEach(acao -> acao.executar(notaFiscal));

        return notaFiscal;
    }

}
