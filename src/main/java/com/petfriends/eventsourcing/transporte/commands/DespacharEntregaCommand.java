package com.petfriends.eventsourcing.transporte.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;
import lombok.Getter;

@Getter
public class DespacharEntregaCommand extends BaseCommand<String> {
    public DespacharEntregaCommand(String id) {
        super(id);
    }
}
