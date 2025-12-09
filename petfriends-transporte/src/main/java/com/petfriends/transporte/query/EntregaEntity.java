package com.petfriends.transporte.query;

import com.petfriends.transporte.query.enums.StatusEntrega;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    @Embedded
    private EnderecoEntrega endereco;
}
