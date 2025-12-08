package com.petfriends.contracts.pedido;

public record PedidoProntoParaEnvioMessage(
        String pedidoId,
        String enderecoEntrega
) {}