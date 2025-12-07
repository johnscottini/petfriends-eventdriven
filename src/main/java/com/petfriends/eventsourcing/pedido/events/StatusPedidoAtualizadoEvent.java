package com.petfriends.eventsourcing.pedido.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import com.petfriends.eventsourcing.pedido.query.enums.StatusPedido;

public class StatusPedidoAtualizadoEvent extends BaseEvent {

    private StatusPedido novoStatus;

    public StatusPedidoAtualizadoEvent(String id, StatusPedido novoStatus) {
        super(id);
        this.novoStatus = novoStatus;
    }
}
