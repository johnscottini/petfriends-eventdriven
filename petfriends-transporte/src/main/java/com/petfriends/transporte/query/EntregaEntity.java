package com.petfriends.transporte.query;

import com.petfriends.transporte.query.enums.StatusEntrega;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entregas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaEntity {

    @Id
    private String entregaId;

    private String pedidoId;

    private StatusEntrega statusEntrega;

    @Embedded
    private EnderecoEntrega endereco;

    public void atualizarStatus(StatusEntrega newStatus) {
        this.statusEntrega = newStatus;
    }
}
