package com.petfriends.transporte.api;

import com.petfriends.transporte.commands.ConcluirEntregaCommand;
import com.petfriends.transporte.commands.CriarEntregaCommand;
import com.petfriends.transporte.commands.DespacharEntregaCommand;
import com.petfriends.transporte.dto.CriarEntregaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/transporte/entregas")
@RequiredArgsConstructor
public class EntregaController {

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> criarEntrega(@RequestBody CriarEntregaRequest req) {
        String entregaId = UUID.randomUUID().toString();

        return commandGateway.send(new CriarEntregaCommand(
                entregaId,
                req.getPedidoId(),
                req.getEnderecoEntrega()
        ));
    }

    @PostMapping("/{id}/despachar")
    public CompletableFuture<String> despacharEntrega(@PathVariable("id") String entregaId) {
        return commandGateway.send(new DespacharEntregaCommand(entregaId));
    }

    @PostMapping("/{id}/concluir")
    public CompletableFuture<String> concluirEntrega(@PathVariable("id") String entregaId) {
        return commandGateway.send(new ConcluirEntregaCommand(entregaId));
    }
}