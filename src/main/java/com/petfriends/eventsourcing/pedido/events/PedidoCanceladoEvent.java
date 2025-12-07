package com.petfriends.eventsourcing.pedido.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;

public class PedidoCanceladoEvent extends BaseEvent {
    public PedidoCanceladoEvent(String id) {
        super(id);
    }
}
