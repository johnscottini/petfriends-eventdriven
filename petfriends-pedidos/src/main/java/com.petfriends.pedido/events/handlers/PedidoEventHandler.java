package com.petfriends.pedido.events.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final CommandGateway commandGateway;
/*
    @EventHandler
    public void on(PedidoConfirmadoEvent event) {

        commandGateway.send(
                new ReservarEstoqueCommand(
                        event.getId(),
                        event.getItens()
                )
        );
    }*/
}
