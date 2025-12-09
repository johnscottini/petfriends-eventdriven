package com.petfriends.pedido.events;

import com.petfriends.pedido.query.enums.StatusPedido;
import events.BaseEvent;

public class StatusPedidoAtualizadoEvent extends BaseEvent {

    private StatusPedido novoStatus;

    public StatusPedidoAtualizadoEvent(String id, StatusPedido novoStatus) {
        super(id);
        this.novoStatus = novoStatus;
    }
}
