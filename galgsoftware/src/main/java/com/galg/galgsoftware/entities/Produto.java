package com.galg.galgsoftware;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal precoVenda;

    @Column(unique = true)
    private String codigoBarras;

    private String tipoEmbalagem;

    private String descricao;

    public Produto(String codigoBarras, String descricao, BigDecimal precoVenda, String tipoEmbalagem){
        this.id = null;
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.tipoEmbalagem = tipoEmbalagem;
    }
}
