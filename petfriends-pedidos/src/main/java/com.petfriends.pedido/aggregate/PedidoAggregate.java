package com.petfriends.pedido.aggregate;

import com.petfriends.pedido.commands.CancelarPedidoCommand;
import com.petfriends.pedido.commands.ConfirmarPedidoCommand;
import com.petfriends.pedido.commands.CriarPedidoCommand;
import com.petfriends.pedido.commands.PedidoProntoParaEnvioCommand;
import com.petfriends.pedido.events.PedidoCanceladoEvent;
import com.petfriends.pedido.events.PedidoConfirmadoEvent;
import com.petfriends.pedido.events.PedidoCriadoEvent;
import com.petfriends.pedido.events.PedidoProntoParaEnvioEvent;
import com.petfriends.pedido.query.ItemPedido;
import com.petfriends.pedido.query.enums.StatusPedido;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class PedidoAggregate {

    @AggregateIdentifier
    private String pedidoId;

    private String clienteId;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private BigDecimal valorTotal;

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.ALWAYS)
    public void handle(CriarPedidoCommand command) {

        if (this.pedidoId != null) {
            throw new IllegalStateException("Pedido já foi criado.");
        }

        if (command.getItens() == null || command.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve possuir ao menos 1 item.");
        }

        apply(new PedidoCriadoEvent(
                command.getId(),
                command.getClienteId(),
                command.getStatus(),
                command.getItens(),
                command.getValorTotal()
        ));
    }

    @CommandHandler
    public void handle(ConfirmarPedidoCommand cmd) {
        apply(new PedidoConfirmadoEvent(pedidoId, itens, clienteId));
    }

    @CommandHandler
    public void handle(PedidoProntoParaEnvioCommand cmd) {

        if (status != StatusPedido.CONFIRMADO) {
            throw new IllegalStateException("Pedido só pode ficar pronto para envio se estiver CONFIRMADO.");
        }

        apply(new PedidoProntoParaEnvioEvent(
                pedidoId,
                cmd.getEnderecoEntrega()
        ));
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
        this.valorTotal = event.getValorTotal();
    }
    @EventSourcingHandler
    public void on(PedidoProntoParaEnvioEvent event) {
        this.status = StatusPedido.PRONTO_PARA_ENVIO;
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
