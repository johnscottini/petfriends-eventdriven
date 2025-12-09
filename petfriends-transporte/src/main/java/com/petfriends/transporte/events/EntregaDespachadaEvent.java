package com.petfriends.transporte.events;

import events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaDespachadaEvent extends BaseEvent {
    public EntregaDespachadaEvent(String id) {
        super(id);
    }
}
