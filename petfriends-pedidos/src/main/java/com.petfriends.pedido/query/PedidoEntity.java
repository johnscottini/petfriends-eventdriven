package com.petfriends.pedido.query;

import com.petfriends.pedido.query.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

    @Id
    private String pedidoId;

    private String clienteId;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal valorTotal;

    public void atualizarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
    }
}
