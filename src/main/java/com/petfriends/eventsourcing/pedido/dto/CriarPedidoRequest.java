package com.petfriends.eventsourcing.pedido.dto;

import com.petfriends.eventsourcing.pedido.query.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class CriarPedidoRequest {
    private String clienteId;
    private List<ItemPedido> itens;
}
