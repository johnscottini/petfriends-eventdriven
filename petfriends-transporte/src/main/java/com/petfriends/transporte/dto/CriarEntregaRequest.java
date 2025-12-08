package com.petfriends.transporte.dto;

import lombok.Data;

@Data
public class CriarEntregaRequest {
    private String pedidoId;
    private String enderecoEntrega;
}