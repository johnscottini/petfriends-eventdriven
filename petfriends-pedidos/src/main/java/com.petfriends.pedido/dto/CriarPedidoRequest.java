package com.petfriends.pedido.dto;

import com.petfriends.pedido.query.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class CriarPedidoRequest {
    private String clienteId;
    private List<ItemPedido> itens;
}
