package com.petfriends.pedido.messaging;

import com.petfriends.contracts.pedido.PedidoConfirmadoMessage;
import com.petfriends.contracts.pedido.PedidoProntoParaEnvioMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.petfriends.pedido.config.RabbitPedidosConfig.*;

@Component
@RequiredArgsConstructor
public class PedidoIntegrationPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishPedidoConfirmado(PedidoConfirmadoMessage message) {
        rabbitTemplate.convertAndSend(
                EXCHANGE_PEDIDOS,
                ROUTING_PEDIDO_CONFIRMADO,
                message
        );
    }

    public void publishPedidoProntoParaEnvio(PedidoProntoParaEnvioMessage message) {
        rabbitTemplate.convertAndSend(
                EXCHANGE_PEDIDOS,
                ROUTING_PEDIDO_PRONTO_ENVIO,
                message
        );
    }
}