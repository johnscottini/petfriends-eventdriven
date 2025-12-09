package com.petfriends.transporte.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTransporteConfig {

    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_PEDIDO_PRONTO_ENVIO = "pedido.pronto-envio";
    public static final String QUEUE_PEDIDO_PRONTO_ENVIO = "transporte.pedido-pronto-envio";

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Queue transportePedidoProntoEnvioQueue() {
        return new Queue(QUEUE_PEDIDO_PRONTO_ENVIO, true);
    }

    @Bean
    public Binding transportePedidoProntoEnvioBinding(Queue transportePedidoProntoEnvioQueue) {
        TopicExchange exchange = new TopicExchange(EXCHANGE_PEDIDOS);
        return BindingBuilder
                .bind(transportePedidoProntoEnvioQueue)
                .to(exchange)
                .with(ROUTING_PEDIDO_PRONTO_ENVIO);
    }

    @Bean
    public MessageConverter jacksonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}