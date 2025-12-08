package com.petfriends.almoxarifado.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Getter
public class ReservarEstoqueCommand {

    @TargetAggregateIdentifier
    private final String estoqueId = "ESTOQUE-GERAL";
    private final String pedidoId;
    //private final List<ItemPedido> itens;

    public ReservarEstoqueCommand(String pedidoId) {
        this.pedidoId = pedidoId;
    }
}
