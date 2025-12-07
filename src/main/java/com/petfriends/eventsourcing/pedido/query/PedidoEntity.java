package com.petfriends.eventsourcing.pedido.query;

import com.petfriends.eventsourcing.pedido.query.enums.StatusEntrega;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

    @Id
    private String pedidoId;

    private StatusEntrega statusEntrega;

    @Embedded
    private EnderecoEntrega endereco;

    public void atualizarStatus(StatusEntrega newStatus) {
        this.statusEntrega = newStatus;
    }
}
