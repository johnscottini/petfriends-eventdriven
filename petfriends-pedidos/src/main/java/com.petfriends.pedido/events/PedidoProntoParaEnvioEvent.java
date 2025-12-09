package com.petfriends.pedido.events;

import com.petfriends.contracts.pedido.EnderecoEntregaMessage;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class PedidoProntoParaEnvioEvent extends BaseEvent {

    private final EnderecoEntregaMessage enderecoEntrega;

    public PedidoProntoParaEnvioEvent(String id, EnderecoEntregaMessage enderecoEntrega) {
        super(id);
        this.enderecoEntrega = enderecoEntrega;
    }
}
