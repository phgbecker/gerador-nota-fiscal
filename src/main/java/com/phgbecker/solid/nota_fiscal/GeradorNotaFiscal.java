package com.phgbecker.solid.nota_fiscal;

import com.phgbecker.solid.acao.AcaoNotaFiscal;
import com.phgbecker.solid.imposto.Imposto;

import java.util.Collections;
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
        this.produtos = produtos;
        this.impostos = impostos;
        this.acoesAposEmissao = acoesAposEmissao;
    }

    public NotaFiscal gerar() {
        NotaFiscal notaFiscal = new NotaFiscal.Builder(detalhe, emitente, destinatario)
                .withProdutos(produtos)
                .withImpostos(impostos)
                .build();

        if (!acoesAposEmissao.isEmpty())
            acoesAposEmissao.forEach(acao -> acao.executar(notaFiscal));

        return notaFiscal;
    }

    public static class Builder {
        private final Detalhe detalhe;
        private final Emitente emitente;
        private final Destinatario destinatario;
        private List<Produto> produtos;
        private List<Imposto> impostos;
        private List<AcaoNotaFiscal> acoesAposEmissao;

        public Builder(Detalhe detalhe, Emitente emitente, Destinatario destinatario) {
            this.detalhe = detalhe;
            this.emitente = emitente;
            this.destinatario = destinatario;
            this.acoesAposEmissao = Collections.emptyList();
        }

        public Builder withProdutos(List<Produto> produtos) {
            this.produtos = produtos;
            return this;
        }

        public Builder withImpostos(List<Imposto> impostos) {
            this.impostos = impostos;
            return this;
        }

        public Builder withAcoesAposEmissao(List<AcaoNotaFiscal> acoesAposEmissao) {
            this.acoesAposEmissao = acoesAposEmissao;
            return this;
        }

        public GeradorNotaFiscal build() {
            return new GeradorNotaFiscal(detalhe, emitente, destinatario, produtos, impostos, acoesAposEmissao);
        }
    }
}
