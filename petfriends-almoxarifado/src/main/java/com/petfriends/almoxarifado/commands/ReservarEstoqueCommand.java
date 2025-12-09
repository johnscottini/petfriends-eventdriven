package com.petfriends.almoxarifado.commands;

import com.petfriends.contracts.pedido.ItemPedidoMessage;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Getter
public class ReservarEstoqueCommand {

    @TargetAggregateIdentifier
    private final String estoqueId = "ESTOQUE-GERAL";
    private final String pedidoId;
    private final List<ItemPedidoMessage> itens;

    public ReservarEstoqueCommand(String pedidoId, List<ItemPedidoMessage> itens) {
        this.pedidoId = pedidoId;
        this.itens = itens;
    }
}
