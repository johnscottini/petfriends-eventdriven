package com.petfriends.almoxarifado.messaging;

import com.petfriends.almoxarifado.commands.ReservarEstoqueCommand;
import com.petfriends.contracts.pedido.ItemPedidoMessage;
import com.petfriends.contracts.pedido.PedidoConfirmadoMessage;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.petfriends.almoxarifado.config.RabbitAlmoxarifadoConfig.QUEUE_PEDIDO_CONFIRMADO;

@Service
@RequiredArgsConstructor
public class PedidoEventsListenerAlmoxarifado {

    private final CommandGateway commandGateway;

    @RabbitListener(queues = QUEUE_PEDIDO_CONFIRMADO)
    public void onPedidoConfirmado(PedidoConfirmadoMessage message) {

        var itensReserva = message.itens().stream()
                .map(i -> new ItemPedidoMessage(i.produtoId(), i.quantidade()))
                .toList();

        var cmd = new ReservarEstoqueCommand(
                message.pedidoId(),
                itensReserva
        );


        commandGateway.send(cmd);
    }
}