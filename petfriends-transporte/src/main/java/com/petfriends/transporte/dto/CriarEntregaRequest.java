package com.petfriends.transporte.dto;

import com.petfriends.contracts.pedido.EnderecoEntregaMessage;
import lombok.Data;

@Data
public class CriarEntregaRequest {
    private String pedidoId;
    private EnderecoEntregaMessage enderecoEntrega;
}