package com.galg.galgsoftware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
public class VendaItem {
    @Id
    private Long id;

    private BigDecimal quantidade;

    private BigDecimal desconto;

    private BigDecimal acrescimo;

    @OneToOne
    private Produto produto;

    public BigDecimal getTotal(){
        return produto.getPrecoVenda().multiply(quantidade);
    }
}
