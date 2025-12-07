package com.petfriends.eventsourcing.pedido.aggregate;

import com.petfriends.eventsourcing.pedido.commands.CancelarPedidoCommand;
import com.petfriends.eventsourcing.pedido.commands.ConfirmarPedidoCommand;
import com.petfriends.eventsourcing.pedido.commands.CriarPedidoCommand;
import com.petfriends.eventsourcing.pedido.events.PedidoCanceladoEvent;
import com.petfriends.eventsourcing.pedido.events.PedidoConfirmadoEvent;
import com.petfriends.eventsourcing.pedido.events.PedidoCriadoEvent;
import com.petfriends.eventsourcing.pedido.query.ItemPedido;
import com.petfriends.eventsourcing.pedido.query.enums.StatusPedido;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class PedidoAggregate {

    @AggregateIdentifier
    private String pedidoId;

    private String clienteId;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private BigDecimal valorTotal;

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {

        if (command.getItens() == null || command.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve possuir ao menos 1 item.");
        }

        apply(new PedidoCriadoEvent(
                command.getId(),
                command.getClienteId(),
                command.getStatus(),
                command.getValorTotal(),
                command.getItens()
        ));
    }

    @CommandHandler
    public void handle(ConfirmarPedidoCommand cmd) {
        if (status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException("Pedido não pode ser confirmado.");
        }
        apply(new PedidoConfirmadoEvent(pedidoId, itens));
    }

    @CommandHandler
    public void handle(CancelarPedidoCommand cmd) {
        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Pedido já está cancelado.");
        }
        apply(new PedidoCanceladoEvent(pedidoId));
    }

    @EventSourcingHandler
    public void on(PedidoCriadoEvent event) {
        this.pedidoId = event.getId();
        this.clienteId = event.getClienteId();
        this.itens = event.getItens();
        this.status = event.getStatus();
        this.valorTotal = itens.stream()
                .map(ItemPedido::calcularTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    @EventSourcingHandler
    public void on(PedidoConfirmadoEvent event) {
        this.status = StatusPedido.CONFIRMADO;
    }

    @EventSourcingHandler
    public void on(PedidoCanceladoEvent event) {
        this.status = StatusPedido.CANCELADO;
    }
}
