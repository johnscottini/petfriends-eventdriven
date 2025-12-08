package com.petfriends.almoxarifado.query;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estoque_itens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstoqueEntity {
    @Id
    private String produtoId;

    private String nome;

    private Integer quantidadeDisponivel;

    @Embedded
    private Dimensoes dimensoes;

    public void baixarEstoque(int quantidade) {
        this.quantidadeDisponivel = Math.max(0, this.quantidadeDisponivel - quantidade);
    }

    public void reporEstoque(int quantidade) {
        this.quantidadeDisponivel += quantidade;
    }
}
