package com.phgbecker.solid;

import com.phgbecker.solid.acao.AcaoEnviarEmail;
import com.phgbecker.solid.acao.AcaoImprimirCupomFiscal;
import com.phgbecker.solid.acao.AcaoNotaFiscal;
import com.phgbecker.solid.acao.AcaoSalvarNotaFiscal;
import com.phgbecker.solid.imposto.Imposto;
import com.phgbecker.solid.imposto.ImpostoFundoCombatePobreza;
import com.phgbecker.solid.imposto.ImpostoMercadoriaEstrangeira;
import com.phgbecker.solid.nota_fiscal.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Gerador {

    public static void main(String[] args) {

        Detalhe detalhe = new Detalhe(1L);
        Emitente emitente = new Emitente("Amazon.com");
        Destinatario destinatario = new Destinatario("Maria da Silva", "maria@email.com.br");

        List<Produto> produtos = Arrays.asList(
                new Produto("Intel Core i9 8th gen Processor", new BigDecimal("300.00")),
                new Produto("Kingston 500GB SSD", new BigDecimal("150.00"))
        );

        List<Imposto> impostos = Arrays.asList(
                new ImpostoMercadoriaEstrangeira(),
                new ImpostoFundoCombatePobreza()
        );

        List<AcaoNotaFiscal> acoes = Arrays.asList(
                new AcaoSalvarNotaFiscal(),
                new AcaoImprimirCupomFiscal(),
                new AcaoEnviarEmail()
        );


        GeradorNotaFiscal geradorNotaFiscal = new GeradorNotaFiscal(
                detalhe,
                emitente,
                destinatario,
                produtos,
                impostos,
                acoes
        );
        geradorNotaFiscal.gerar();
    }
}
