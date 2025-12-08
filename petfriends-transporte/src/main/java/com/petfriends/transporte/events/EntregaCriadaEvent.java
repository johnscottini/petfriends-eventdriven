package com.petfriends.transporte.events;

import events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaCriadaEvent extends BaseEvent {

    private final String pedidoId;
    private final String enderecoEntrega;

    public EntregaCriadaEvent(String id, String pedidoId, String enderecoEntrega) {
        super(id);
        this.pedidoId = pedidoId;
        this.enderecoEntrega = enderecoEntrega;
    }
}
