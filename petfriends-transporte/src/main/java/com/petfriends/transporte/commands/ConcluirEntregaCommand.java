package com.petfriends.transporte.commands;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class ConcluirEntregaCommand extends BaseCommand<String> {
    public ConcluirEntregaCommand(String id) {
        super(id);
    }
}
