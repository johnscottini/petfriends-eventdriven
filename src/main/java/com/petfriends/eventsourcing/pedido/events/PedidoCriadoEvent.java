package com.petfriends.eventsourcing.pedido.events;

import com.petfriends.eventsourcing.core.events.BaseEvent;
import com.petfriends.eventsourcing.pedido.query.ItemPedido;
import com.petfriends.eventsourcing.pedido.query.enums.StatusPedido;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class PedidoCriadoEvent extends BaseEvent {

    private String clienteId;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private BigDecimal valorTotal;

        public PedidoCriadoEvent(String pedidoId, String clienteId, StatusPedido status, BigDecimal valorTotal, List<ItemPedido> itens) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.status = status;
        this.valorTotal = valorTotal;
        this.itens = itens;
    }
}
