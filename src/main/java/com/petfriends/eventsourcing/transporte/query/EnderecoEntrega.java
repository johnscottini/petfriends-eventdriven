package com.petfriends.eventsourcing.transporte.query;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntrega {

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}