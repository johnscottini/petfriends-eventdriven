package com.petfriends.eventsourcing.pedido.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import com.petfriends.eventsourcing.pedido.query.ItemPedido;
import lombok.Getter;

import java.util.List;

@Getter
public class PedidoConfirmadoEvent extends BaseEvent {

    private final List<ItemPedido> itens;

    public PedidoConfirmadoEvent(String id, List<ItemPedido> itens) {
        super(id);
        this.itens = itens;
    }
}
