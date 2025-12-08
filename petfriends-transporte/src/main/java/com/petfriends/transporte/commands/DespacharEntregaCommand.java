package com.petfriends.transporte.commands;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class DespacharEntregaCommand extends BaseCommand<String> {
    public DespacharEntregaCommand(String id) {
        super(id);
    }
}
