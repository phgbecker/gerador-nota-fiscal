package com.phgbecker.solid.imposto;

import java.math.BigDecimal;

public class ImpostoMercadoriaEstrangeira implements Imposto {

    @Override
    public BigDecimal getPorcentagem() {
        return new BigDecimal(500.00);
    }
}
