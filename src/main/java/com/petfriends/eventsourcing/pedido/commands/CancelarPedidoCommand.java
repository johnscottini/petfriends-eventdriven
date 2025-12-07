package com.petfriends.eventsourcing.pedido.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;

public class CancelarPedidoCommand extends BaseCommand<String> {

    public CancelarPedidoCommand(String id) {
        super(id);
    }
}
