package com.petfriends.pedido.events;

import com.petfriends.pedido.query.ItemPedido;
import events.BaseEvent;
import lombok.Getter;

import java.util.List;

@Getter
public class PedidoConfirmadoEvent extends BaseEvent {

    private final List<ItemPedido> itens;
    private final String clienteId;

    public PedidoConfirmadoEvent(String id, List<ItemPedido> itens, String clienteId) {
        super(id);
        this.itens = itens;
        this.clienteId = clienteId;
    }
}
