package com.petfriends.pedido.commands;

import com.petfriends.pedido.query.enums.StatusPedido;
import commands.BaseCommand;

public class AtualizarStatusPedidoCommand extends BaseCommand<String> {

    private StatusPedido novoStatus;

    public AtualizarStatusPedidoCommand(String id, StatusPedido novoStatus) {
        super(id);
        this.novoStatus = novoStatus;
    }
}