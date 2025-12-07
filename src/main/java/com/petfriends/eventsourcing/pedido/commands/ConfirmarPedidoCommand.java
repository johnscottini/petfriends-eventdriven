package com.petfriends.eventsourcing.pedido.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;

public class ConfirmarPedidoCommand extends BaseCommand<String> {

    public ConfirmarPedidoCommand(String id) {
        super(id);
    }
}
