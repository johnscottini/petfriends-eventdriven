package com.petfriends.transporte.commands;

import com.petfriends.contracts.pedido.EnderecoEntregaMessage;
import commands.BaseCommand;
import lombok.Getter;

@Getter
public class CriarEntregaCommand extends BaseCommand<String> {

    private final String pedidoId;
    private final EnderecoEntregaMessage enderecoEntrega;

    public CriarEntregaCommand(String id, String pedidoId, EnderecoEntregaMessage enderecoEntrega) {
        super(id);
        this.pedidoId = pedidoId;
        this.enderecoEntrega = enderecoEntrega;
    }
}
