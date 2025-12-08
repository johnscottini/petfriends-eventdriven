package com.petfriends.transporte.events;

import events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaConcluidaEvent extends BaseEvent {
    public EntregaConcluidaEvent(String id) {
        super(id);
    }
}
