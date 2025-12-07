package com.petfriends.eventsourcing.pedido.events.handlers;

import com.petfriends.eventsourcing.almoxarifado.events.EstoqueInsuficienteEvent;
import com.petfriends.eventsourcing.almoxarifado.events.EstoqueReservadoEvent;
import com.petfriends.eventsourcing.pedido.commands.AtualizarStatusPedidoCommand;
import com.petfriends.eventsourcing.pedido.query.enums.StatusPedido;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlmoxarifadoEventHandler {

    private final CommandGateway commandGateway;

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
    }
}
