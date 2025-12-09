package com.petfriends.pedido.events.handlers;

import com.petfriends.contracts.pedido.ItemPedidoMessage;
import com.petfriends.contracts.pedido.PedidoConfirmadoMessage;
import com.petfriends.contracts.pedido.PedidoProntoParaEnvioMessage;
import com.petfriends.pedido.events.PedidoConfirmadoEvent;
import com.petfriends.pedido.events.PedidoProntoParaEnvioEvent;
import com.petfriends.pedido.messaging.PedidoIntegrationPublisher;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final PedidoIntegrationPublisher publisher;

    @EventHandler
    public void on(PedidoConfirmadoEvent event) {
        var message = new PedidoConfirmadoMessage(
                event.getId(),
                event.getClienteId(),
                event.getItens().stream()
                        .map(i -> new ItemPedidoMessage(i.getProdutoId(), i.getQuantidade()))
                        .toList()
        );
        publisher.publishPedidoConfirmado(message);
    }

    @EventHandler
    public void on(PedidoProntoParaEnvioEvent event) {
        var message = new PedidoProntoParaEnvioMessage(
                event.getId(),
                event.getEnderecoEntrega()
        );
        publisher.publishPedidoProntoParaEnvio(message);
    }
}