package com.petfriends.eventsourcing.pedido.commands;

import com.petfriends.eventsourcing.core.commands.BaseCommand;
import com.petfriends.eventsourcing.pedido.query.enums.StatusPedido;

public class AtualizarStatusPedidoCommand extends BaseCommand<String> {

    private StatusPedido novoStatus;

    public AtualizarStatusPedidoCommand(String id, StatusPedido novoStatus) {
        super(id);
        this.novoStatus = novoStatus;
    }
}