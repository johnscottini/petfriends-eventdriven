package com.petfriends.pedido.api;

import com.petfriends.pedido.commands.ConfirmarPedidoCommand;
import com.petfriends.pedido.commands.CriarPedidoCommand;
import com.petfriends.pedido.dto.CriarPedidoRequest;
import com.petfriends.pedido.query.enums.StatusPedido;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final CommandGateway commandGateway;

    @PostMapping("/criar")
    public CompletableFuture<String> criarPedido(@RequestBody CriarPedidoRequest req) {

        String pedidoId = UUID.randomUUID().toString();

        return commandGateway.send(new CriarPedidoCommand(
                pedidoId,
                req.getClienteId(),
                req.getItens(),
                StatusPedido.AGUARDANDO_PAGAMENTO
        ));
    }

    @PostMapping("/{pedidoId}/confirmar")
    public CompletableFuture<String> confirmarPedido(@PathVariable String pedidoId) {
        return commandGateway.send(new ConfirmarPedidoCommand(pedidoId));
    }
}
