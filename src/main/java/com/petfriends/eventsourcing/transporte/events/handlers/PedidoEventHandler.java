package com.petfriends.eventsourcing.transporte.events.handlers;

import com.petfriends.eventsourcing.pedido.events.PedidoProntoParaEnvioEvent;
import com.petfriends.eventsourcing.transporte.commands.CriarEntregaCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final CommandGateway commandGateway;

    @EventHandler
    public void on(PedidoProntoParaEnvioEvent event) {

        commandGateway.send(
                new CriarEntregaCommand(
                        UUID.randomUUID().toString(),
                        event.getId(),
                        event.getEnderecoEntrega()
                )
        );
    }
}
