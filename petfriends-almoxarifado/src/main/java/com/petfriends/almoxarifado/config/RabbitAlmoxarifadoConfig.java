package com.petfriends.almoxarifado.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitAlmoxarifadoConfig {

    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_PEDIDO_CONFIRMADO = "pedido.confirmado";
    public static final String QUEUE_PEDIDO_CONFIRMADO = "almoxarifado.pedido-confirmado";

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Queue almoxarifadoPedidoConfirmadoQueue() {
        return new Queue(QUEUE_PEDIDO_CONFIRMADO, true);
    }

    @Bean
    public Binding almoxarifadoPedidoConfirmadoBinding(Queue almoxarifadoPedidoConfirmadoQueue,
                                                       TopicExchange pedidosExchange) {
        return BindingBuilder
                .bind(almoxarifadoPedidoConfirmadoQueue)
                .to(pedidosExchange)
                .with(ROUTING_PEDIDO_CONFIRMADO);
    }

    @Bean
    public MessageConverter jacksonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}