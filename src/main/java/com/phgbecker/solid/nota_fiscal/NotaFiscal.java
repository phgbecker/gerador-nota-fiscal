package com.phgbecker.solid.nota_fiscal;

import com.phgbecker.solid.imposto.Imposto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NotaFiscal {
    private final Detalhe detalhe;
    private final Emitente emitente;
    private final Destinatario destinatario;
    private final List<Produto> produtos;
    private final List<Imposto> impostos;

    public NotaFiscal(Detalhe detalhe, Emitente emitente, Destinatario destinatario, List<Produto> produtos, List<Imposto> impostos) {
        this.detalhe = detalhe;
        this.emitente = emitente;
        this.destinatario = destinatario;
        this.produtos = produtos;
        this.impostos = impostos;
    }

    public Detalhe getDetalhe() {
        return detalhe;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public List<Imposto> getImpostos() {
        return Collections.unmodifiableList(impostos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscal that = (NotaFiscal) o;
        return Objects.equals(detalhe, that.detalhe) &&
                Objects.equals(emitente, that.emitente) &&
                Objects.equals(destinatario, that.destinatario) &&
                Objects.equals(produtos, that.produtos) &&
                Objects.equals(impostos, that.impostos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalhe, emitente, destinatario, produtos, impostos);
    }
}
