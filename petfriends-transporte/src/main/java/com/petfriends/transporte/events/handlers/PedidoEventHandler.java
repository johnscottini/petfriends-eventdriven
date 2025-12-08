package com.petfriends.transporte.events.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final CommandGateway commandGateway;

/*    @EventHandler
    public void on(PedidoProntoParaEnvioEvent event) {

        commandGateway.send(
                new CriarEntregaCommand(
                        UUID.randomUUID().toString(),
                        event.getId(),
                        event.getEnderecoEntrega()
                )
        );
    }*/
}
