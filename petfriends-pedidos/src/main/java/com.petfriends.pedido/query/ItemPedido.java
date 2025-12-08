package com.petfriends.pedido.query;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ItemPedido {

    String produtoId;
    int quantidade;
    BigDecimal precoUnitario;

    public BigDecimal calcularTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
