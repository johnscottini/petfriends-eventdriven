package com.petfriends.eventsourcing.transporte.aggregate;

import com.petfriends.eventsourcing.transporte.commands.ConcluirEntregaCommand;
import com.petfriends.eventsourcing.transporte.commands.CriarEntregaCommand;
import com.petfriends.eventsourcing.transporte.commands.DespacharEntregaCommand;
import com.petfriends.eventsourcing.transporte.events.EntregaConcluidaEvent;
import com.petfriends.eventsourcing.transporte.events.EntregaCriadaEvent;
import com.petfriends.eventsourcing.transporte.events.EntregaDespachadaEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class EntregaAggregate {

    @AggregateIdentifier
    private String entregaId;

    private String pedidoId;
    private String enderecoEntrega;
    private boolean despachada;
    private boolean concluida;

    @CommandHandler
    public EntregaAggregate(CriarEntregaCommand command) {
        apply(new EntregaCriadaEvent(
                command.getId(),
                command.getPedidoId(),
                command.getEnderecoEntrega()
        ));
    }

    @EventSourcingHandler
    public void on(EntregaCriadaEvent event) {
        this.entregaId = event.getId();
        this.pedidoId = event.getPedidoId();
        this.enderecoEntrega = event.getEnderecoEntrega();
        this.despachada = false;
        this.concluida = false;
    }

    @CommandHandler
    public void handle(DespacharEntregaCommand command) {
        if (!despachada) {
            apply(new EntregaDespachadaEvent(command.getId()));
        }
    }

    @EventSourcingHandler
    public void on(EntregaDespachadaEvent event) {
        this.despachada = true;
    }

    @CommandHandler
    public void handle(ConcluirEntregaCommand command) {
        if (despachada && !concluida) {
            apply(new EntregaConcluidaEvent(command.getId()));
        }
    }

    @EventSourcingHandler
    public void on(EntregaConcluidaEvent event) {
        this.concluida = true;
    }
}
