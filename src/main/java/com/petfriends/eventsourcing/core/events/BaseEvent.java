package com.petfriends.eventsourcing.core.events;

import lombok.Getter;

import java.time.Instant;

@Getter
public abstract class BaseEvent {

    private final String id;
    private final Instant timestamp;

    public BaseEvent(String id) {
        this.id = id;
        this.timestamp = Instant.now();
    }
}
