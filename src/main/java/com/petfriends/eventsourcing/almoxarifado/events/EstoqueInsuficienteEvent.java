package com.petfriends.eventsourcing.almoxarifado.events;

import com.petfriends.eventsourcing.pedido.query.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class EstoqueInsuficienteEvent {

    private final String pedidoId;
    private final List<ItemPedido> itens;
}
