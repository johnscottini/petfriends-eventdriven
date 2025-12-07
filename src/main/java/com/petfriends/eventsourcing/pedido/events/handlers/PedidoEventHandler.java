package com.petfriends.eventsourcing.pedido.events.handlers;

import com.petfriends.eventsourcing.almoxarifado.commands.ReservarEstoqueCommand;
import com.petfriends.eventsourcing.pedido.events.PedidoConfirmadoEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void on(PedidoConfirmadoEvent event) {

        commandGateway.send(
                new ReservarEstoqueCommand(
                        event.getId(),
                        event.getItens()
                )
        );
    }
}
