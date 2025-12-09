package com.petfriends.contracts.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntregaMessage {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}