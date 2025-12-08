package com.petfriends.pedido.events;

import com.petfriends.pedido.query.ItemPedido;
import events.BaseEvent;
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
