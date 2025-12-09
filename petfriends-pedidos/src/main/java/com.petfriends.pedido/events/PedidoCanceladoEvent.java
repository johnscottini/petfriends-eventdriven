package com.petfriends.pedido.events;

import events.BaseEvent;

public class PedidoCanceladoEvent extends BaseEvent {
    public PedidoCanceladoEvent(String id) {
        super(id);
    }
}
