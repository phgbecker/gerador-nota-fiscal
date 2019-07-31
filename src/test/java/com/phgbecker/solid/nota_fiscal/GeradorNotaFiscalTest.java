package com.phgbecker.solid.nota_fiscal;

import com.phgbecker.solid.acao.AcaoEnviarEmail;
import com.phgbecker.solid.acao.AcaoImprimirCupomFiscal;
import com.phgbecker.solid.acao.AcaoNotaFiscal;
import com.phgbecker.solid.acao.AcaoSalvarNotaFiscal;
import com.phgbecker.solid.imposto.Imposto;
import com.phgbecker.solid.imposto.ImpostoFundoCombatePobreza;
import com.phgbecker.solid.imposto.ImpostoMercadoriaEstrangeira;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeradorNotaFiscalTest {
    private Detalhe detalhe;
    private Emitente emitente;
    private Destinatario destinatario;

    @Before
    public void setUp() {
        detalhe = new Detalhe(1L);
        emitente = new Emitente("Amazon.com");
        destinatario = new Destinatario("Maria da Silva", "maria@email.com.br");
    }

    @Test
    public void givenGerador_whenGerar_thenNotaIsEquals() {
        List<Produto> produtos = Arrays.asList(
                new Produto("Intel Core i9 8th gen Processor", new BigDecimal("300.00")),
                new Produto("Kingston 500GB SSD", new BigDecimal("150.00"))
        );

        List<Imposto> impostos = Arrays.asList(
                new ImpostoMercadoriaEstrangeira(),
                new ImpostoFundoCombatePobreza()
        );

        GeradorNotaFiscal gerador = new GeradorNotaFiscal.Builder(detalhe, emitente, destinatario)
                .withProdutos(produtos)
                .withImpostos(impostos)
                .build();

        NotaFiscal notaFiscal = new NotaFiscal(
                detalhe,
                emitente,
                destinatario,
                produtos,
                impostos
        );

        assertThat(gerador.gerar()).isEqualTo(notaFiscal);
    }

    @Test
    public void givenAcoes_whenGerar_thenOutputStreamContains() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorOutputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorOutputStream));

        List<AcaoNotaFiscal> acoes = Arrays.asList(
                new AcaoSalvarNotaFiscal(),
                new AcaoImprimirCupomFiscal(),
                new AcaoEnviarEmail()
        );

        new GeradorNotaFiscal.Builder(detalhe, emitente, destinatario)
                .withAcoesAposEmissao(acoes)
                .build()
                .gerar();

        assertThat(outputStream.toString())
                .contains("Salvando")
                .contains("Imprimindo")
                .contains("Enviando");
    }
}