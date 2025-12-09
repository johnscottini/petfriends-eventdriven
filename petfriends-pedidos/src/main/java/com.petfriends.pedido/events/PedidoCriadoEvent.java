package com.petfriends.pedido.events;

import com.petfriends.pedido.query.ItemPedido;
import com.petfriends.pedido.query.enums.StatusPedido;
import events.BaseEvent;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class PedidoCriadoEvent extends BaseEvent {

    private String clienteId;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private BigDecimal valorTotal;

    public PedidoCriadoEvent(String pedidoId, String clienteId, StatusPedido status, List<ItemPedido> itens, BigDecimal valorTotal) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.status = status;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }
}
