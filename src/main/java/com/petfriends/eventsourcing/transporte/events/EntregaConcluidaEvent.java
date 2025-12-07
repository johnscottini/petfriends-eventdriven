package com.petfriends.eventsourcing.transporte.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import lombok.Getter;

@Getter
public class EntregaConcluidaEvent extends BaseEvent {
    public EntregaConcluidaEvent(String id) {
        super(id);
    }
}
