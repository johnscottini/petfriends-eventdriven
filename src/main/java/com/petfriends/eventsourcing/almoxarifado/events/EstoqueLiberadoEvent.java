package com.petfriends.eventsourcing.almoxarifado.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EstoqueLiberadoEvent {

    private final String pedidoId;
}
