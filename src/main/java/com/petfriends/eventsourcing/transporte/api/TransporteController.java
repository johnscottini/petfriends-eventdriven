package com.petfriends.eventsourcing.transporte.api;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/transporte")
@RequiredArgsConstructor
public class TransporteController {

    private final CommandGateway commandGateway;

    @PostMapping("/iniciar")
    public CompletableFuture<String> iniciar(@RequestBody IniciarTransporteCommand cmd) {
        return commandGateway.send(cmd);
    }

    @PostMapping("/{id}/status")
    public CompletableFuture<String> atualizarStatus(@PathVariable String id,
                                                     @RequestParam StatusTransporte novoStatus) {

        return commandGateway.send(
                new AtualizarStatusTransporteCommand(id, novoStatus)
        );
    }

    @PostMapping("/{id}/finalizar")
    public CompletableFuture<String> finalizar(@PathVariable String id) {
        return commandGateway.send(new FinalizarTransporteCommand(id));
    }
}
