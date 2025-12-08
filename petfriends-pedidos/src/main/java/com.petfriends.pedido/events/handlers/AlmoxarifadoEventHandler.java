package com.petfriends.pedido.events.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlmoxarifadoEventHandler {

    private final CommandGateway commandGateway;
/*
    @EventHandler
    public void on(EstoqueReservadoEvent event) {

        commandGateway.send(
                new AtualizarStatusPedidoCommand(
                        event.getPedidoId(),
                        StatusPedido.EM_SEPARACAO
                )
        );
    }

    @EventHandler
    public void on(EstoqueInsuficienteEvent event) {

        commandGateway.send(
                new AtualizarStatusPedidoCommand(
                        event.getPedidoId(),
                        StatusPedido.ESTOQUE_INSUFICIENTE
                )
        );
    }*/
}
