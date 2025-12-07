package com.petfriends.eventsourcing.transporte.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaDespachadaEvent extends BaseEvent {
    public EntregaDespachadaEvent(String id) {
        super(id);
    }
}
