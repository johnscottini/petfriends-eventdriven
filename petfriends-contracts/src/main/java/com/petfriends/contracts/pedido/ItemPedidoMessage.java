package com.petfriends.contracts.pedido;

public record ItemPedidoMessage(
        String produtoId,
        Integer quantidade
) {
}
