package com.petfriends.contracts.pedido;

import java.util.List;

public record PedidoConfirmadoMessage(
        String pedidoId,
        String clienteId,
        List<ItemPedidoMessage> itens
) {}