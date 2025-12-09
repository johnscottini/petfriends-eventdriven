package com.petfriends.transporte.messaging;

import com.petfriends.contracts.pedido.PedidoProntoParaEnvioMessage;
import com.petfriends.transporte.commands.CriarEntregaCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.petfriends.transporte.config.RabbitTransporteConfig.QUEUE_PEDIDO_PRONTO_ENVIO;

@Service
@RequiredArgsConstructor
public class PedidoEventsListenerTransporte {

    private final CommandGateway commandGateway;

    @RabbitListener(queues = QUEUE_PEDIDO_PRONTO_ENVIO)
    public void onPedidoProntoParaEnvio(PedidoProntoParaEnvioMessage message) {

        var cmd = new CriarEntregaCommand(
                UUID.randomUUID().toString(),
                message.pedidoId(),
                message.enderecoEntrega()
        );

        commandGateway.send(cmd);
    }
}