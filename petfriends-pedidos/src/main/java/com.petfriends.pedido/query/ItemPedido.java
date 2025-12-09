package com.petfriends.pedido.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private String produtoId;
    private Integer quantidade;
}