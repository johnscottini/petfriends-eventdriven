package com.petfriends.pedido.commands;

import com.petfriends.contracts.pedido.EnderecoEntregaMessage;
import commands.BaseCommand;
import lombok.Getter;

@Getter
public class PedidoProntoParaEnvioCommand extends BaseCommand<String> {

    private final EnderecoEntregaMessage enderecoEntrega;

    public PedidoProntoParaEnvioCommand(String id, EnderecoEntregaMessage enderecoEntrega) {
        super(id);
        this.enderecoEntrega = enderecoEntrega;
    }
}
