package com.phgbecker.solid.nota_fiscal;

import com.phgbecker.solid.imposto.Imposto;

import java.util.Collections;
import java.util.List;

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
}
