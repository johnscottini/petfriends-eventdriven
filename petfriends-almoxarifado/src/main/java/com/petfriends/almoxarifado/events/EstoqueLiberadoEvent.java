package com.petfriends.almoxarifado.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EstoqueLiberadoEvent {

    private final String pedidoId;
}
