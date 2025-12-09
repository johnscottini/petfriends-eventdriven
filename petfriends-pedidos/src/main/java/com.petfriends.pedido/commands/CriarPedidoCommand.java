package com.petfriends.pedido.commands;

import com.petfriends.pedido.query.ItemPedido;
import com.petfriends.pedido.query.enums.StatusPedido;
import commands.BaseCommand;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class CriarPedidoCommand extends BaseCommand<String> {
    private String clienteId;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private BigDecimal valorTotal;

    public CriarPedidoCommand(String pedidoId, String clienteId, List<ItemPedido> itens, StatusPedido status, BigDecimal valorTotal) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.itens = itens;
        this.status = status;
        this.valorTotal = valorTotal;
    }
}