package com.petfriends.almoxarifado.query;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dimensoes {

    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal largura;
}