package com.petfriends.eventsourcing.pedido.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import lombok.Getter;

@Getter
public class PedidoProntoParaEnvioEvent extends BaseEvent {

    private final String enderecoEntrega;

    public PedidoProntoParaEnvioEvent(String id, String enderecoEntrega) {
        super(id);
        this.enderecoEntrega = enderecoEntrega;
    }
}
