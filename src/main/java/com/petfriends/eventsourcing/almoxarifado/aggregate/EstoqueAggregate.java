package com.petfriends.eventsourcing.almoxarifado.aggregate;


import com.petfriends.eventsourcing.almoxarifado.commands.LiberarEstoqueCommand;
import com.petfriends.eventsourcing.almoxarifado.commands.ReservarEstoqueCommand;
import com.petfriends.eventsourcing.almoxarifado.events.EstoqueInsuficienteEvent;
import com.petfriends.eventsourcing.almoxarifado.events.EstoqueLiberadoEvent;
import com.petfriends.eventsourcing.almoxarifado.events.EstoqueReservadoEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Map;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class EstoqueAggregate {

    @AggregateIdentifier
    private String estoqueId;

    private Map<String, Integer> estoqueAtual;

    @CommandHandler
    public EstoqueAggregate(ReservarEstoqueCommand command) {

        apply(new EstoqueReservadoEvent(
                command.getPedidoId(),
                command.getItens()
        ));
    }

    @CommandHandler
    public void handle(ReservarEstoqueCommand command) {

        boolean temEstoque = command.getItens()
                .stream()
                .allMatch(item -> estoqueAtual.getOrDefault(item.getProdutoId(), 0) >= item.getQuantidade());

        if (temEstoque) {
            apply(new EstoqueReservadoEvent(command.getPedidoId(), command.getItens()));
        } else {
            apply(new EstoqueInsuficienteEvent(command.getPedidoId(), command.getItens()));
        }
    }

    @CommandHandler
    public void handle(LiberarEstoqueCommand command) {
        apply(new EstoqueLiberadoEvent(command.getPedidoId()));
    }

    @EventSourcingHandler
    public void on(EstoqueReservadoEvent event) {
        event.getItens().forEach(item ->
                estoqueAtual.put(
                        item.getProdutoId(),
                        estoqueAtual.get(item.getProdutoId()) - item.getQuantidade()
                )
        );
    }

    @EventSourcingHandler
    public void on(EstoqueInsuficienteEvent event) {
    }

    @EventSourcingHandler
    public void on(EstoqueLiberadoEvent event) {
    }
}
