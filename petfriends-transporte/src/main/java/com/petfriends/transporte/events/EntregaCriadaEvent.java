package com.petfriends.transporte.events;

import com.petfriends.contracts.pedido.EnderecoEntregaMessage;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaCriadaEvent extends BaseEvent {

    private final String pedidoId;
    private final EnderecoEntregaMessage enderecoEntrega;

    public EntregaCriadaEvent(String id, String pedidoId, EnderecoEntregaMessage enderecoEntrega) {
        super(id);
        this.pedidoId = pedidoId;
        this.enderecoEntrega = enderecoEntrega;
    }
}
