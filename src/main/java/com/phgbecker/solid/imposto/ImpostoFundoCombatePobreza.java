package com.phgbecker.solid.imposto;

import java.math.BigDecimal;

public class ImpostoFundoCombatePobreza implements Imposto {

    @Override
    public BigDecimal getPorcentagem() {
        return new BigDecimal(2.00);
    }
}
