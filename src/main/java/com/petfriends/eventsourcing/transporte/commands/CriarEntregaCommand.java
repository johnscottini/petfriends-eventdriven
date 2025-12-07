package com.petfriends.eventsourcing.transporte.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;
import lombok.Getter;

@Getter
public class CriarEntregaCommand extends BaseCommand<String> {

    private final String pedidoId;
    private final String enderecoEntrega;

    public CriarEntregaCommand(String id, String pedidoId, String enderecoEntrega) {
        super(id);
        this.pedidoId = pedidoId;
        this.enderecoEntrega = enderecoEntrega;
    }
}
