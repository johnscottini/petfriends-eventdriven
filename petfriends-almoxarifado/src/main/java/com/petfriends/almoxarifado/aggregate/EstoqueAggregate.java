package com.petfriends.almoxarifado.aggregate;

import com.petfriends.almoxarifado.commands.LiberarEstoqueCommand;
import com.petfriends.almoxarifado.commands.ReservarEstoqueCommand;
import com.petfriends.almoxarifado.events.EstoqueInsuficienteEvent;
import com.petfriends.almoxarifado.events.EstoqueLiberadoEvent;
import com.petfriends.almoxarifado.events.EstoqueReservadoEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Map;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class EstoqueAggregate {

    @AggregateIdentifier
    private String estoqueId;

    private Map<String, Integer> estoqueAtual = new HashMap<>();

    @CommandHandler
    public void handle(ReservarEstoqueCommand command) {
        this.estoqueId = command.getEstoqueId();
        handleReservar(command);
    }

    private void handleReservar(ReservarEstoqueCommand command) {

        boolean temEstoque = command.getItens()
                .stream()
                .allMatch(item ->
                        estoqueAtual.getOrDefault(item.produtoId(), 0) >= item.quantidade()
                );

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
                estoqueAtual.merge(
                        item.produtoId(),
                        -item.quantidade(),
                        Integer::sum
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
