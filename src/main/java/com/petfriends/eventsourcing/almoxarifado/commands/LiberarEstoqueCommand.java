package com.petfriends.eventsourcing.almoxarifado.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;
import lombok.Getter;

@Getter
public class LiberarEstoqueCommand extends BaseCommand<String> {

    private final String pedidoId;

    public LiberarEstoqueCommand(String id, String pedidoId) {
        super(id);
        this.pedidoId = pedidoId;
    }
}
