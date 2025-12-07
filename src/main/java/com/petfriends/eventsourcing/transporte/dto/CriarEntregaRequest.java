package com.petfriends.eventsourcing.transporte.dto;

import lombok.Data;

@Data
public class CriarEntregaRequest {
    private String pedidoId;
    private String enderecoEntrega;
}