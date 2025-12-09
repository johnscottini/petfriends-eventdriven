package com.petfriends.almoxarifado.events;

import com.petfriends.contracts.pedido.ItemPedidoMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class EstoqueInsuficienteEvent {

    private final String pedidoId;
    private final List<ItemPedidoMessage> itens;
}
