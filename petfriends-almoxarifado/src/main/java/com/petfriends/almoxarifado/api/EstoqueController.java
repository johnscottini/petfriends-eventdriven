package com.petfriends.almoxarifado.api;

import com.petfriends.almoxarifado.commands.ReservarEstoqueCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/almoxarifado/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final CommandGateway commandGateway;

    @PostMapping("/reservar")
    public CompletableFuture<String> reservar(@RequestBody ReservarEstoqueCommand cmd) {
        return commandGateway.send(cmd);
    }
}
