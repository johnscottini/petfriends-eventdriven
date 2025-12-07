package com.petfriends.eventsourcing.transporte.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;
import lombok.Getter;

@Getter
public class ConcluirEntregaCommand extends BaseCommand<String> {
    public ConcluirEntregaCommand(String id) {
        super(id);
    }
}
